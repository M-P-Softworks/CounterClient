package com.mpsoftworks.data.repository

import com.mpsoftworks.data.api.CounterDbApi
import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import com.mpsoftworks.data.model.CounterValue
import com.mpsoftworks.data.room.dao.CountersDao
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity
import com.mpsoftworks.data.utils.toBitmap
import com.mpsoftworks.data.utils.toByteArray
import javax.inject.Inject
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 *
 */
@OptIn(ExperimentalUuidApi::class)
class RoomDbCounterRepository @Inject constructor(private val counterDao: CountersDao) :
    CounterDbApi {

    override fun getCounterList(counterGroupId: Uuid): Result<List<Counter>> {
        return try {
            Result.success(
                counterDao.getCurrentCounters(counterGroupId).map { entity ->
                    entity.toCounter()
                }
            )
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    override fun addOrUpdateCounter(counter: Counter, groupId: Uuid): Result<Boolean> {
        return try {
            val counterIDs = counterDao.getCurrentCounters(groupId).map { entity -> entity.id }

            counterDao.insertOrUpdateCounter(counter.toCounterEntity(groupId))
            Result.success(counterIDs.contains(counter.id))
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    override fun deleteCounters(counters: List<Counter>, groupId: Uuid): Result<Unit> {
        return try {
            counterDao.deleteCounterList(counters.map { entity ->
                entity.toCounterEntity(groupId)
            })
            Result.success(Unit)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    override fun getGroups(): Result<List<CounterGroup>> {
        return try {
            val groups = counterDao.getGroups()
                .map { entity ->
                    val counters = getCounterList(entity.id).getOrDefault(emptyList())
                    entity.toCounterGroup(counters)
                }
            Result.success(groups)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    override fun addOrUpdateGroup(group: CounterGroup): Result<Boolean> {
        return try {
            val groupIDs = counterDao.getGroups().map { entity -> entity.id }
            counterDao.insertOrUpdateGroup(group.toCounterGroupEntity())
            Result.success(groupIDs.contains(group.id))
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    override fun deleteGroup(groups: List<CounterGroup>): Result<Unit> {
        return try {
            counterDao.deleteGroupList(groups.map { entity -> entity.toCounterGroupEntity() })
            Result.success(Unit)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    //---------------------------------------------------------------------------------------------

    private fun Counter.toCounterEntity(groupId: Uuid): CounterEntity {
        return CounterEntity(id, header, text, value.v?.toDouble(), canDecrease, groupId)
    }

    private fun CounterEntity.toCounter(): Counter {
        return Counter(id, header, text, CounterValue(value?.toSmartNumber() ?: -1))
    }

    private fun CounterGroupEntity.toCounterGroup(counters: List<Counter>): CounterGroup {
        return CounterGroup(id, title ?: STR_EMPTY, color, bitmapArray.toBitmap(), counters)
    }

    private fun CounterGroup.toCounterGroupEntity(): CounterGroupEntity {
        return CounterGroupEntity(id, title, color, bitmap.toByteArray())
    }

    private fun Double.toSmartNumber(): Number {
        return if (this % 1.0 == 0.0) {
            // Если дробная часть 0, возвращаем Int (если помещается) или Long
            val longValue = this.toLong()
            if (longValue <= Int.MAX_VALUE && longValue >= Int.MIN_VALUE) {
                longValue.toInt()
            } else {
                longValue
            }
        } else {
            this
        }
    }

    private companion object {
        private const val STR_EMPTY = ""
    }
}