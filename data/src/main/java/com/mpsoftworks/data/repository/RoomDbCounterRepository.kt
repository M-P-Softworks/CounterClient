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
import java.util.UUID
import javax.inject.Inject

/**
 *
 */
class RoomDbCounterRepository @Inject constructor(private val counterDao: CountersDao) :
    CounterDbApi {

    override fun getCounterList(counterGroupId: UUID): Result<List<Counter>> {
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

    override fun addOrUpdateCounter(counter: Counter, groupId: UUID): Result<Boolean> {
        return try {
            val counterIDs = counterDao.getCurrentCounters(groupId).map { entity -> entity.id }

            counterDao.insertOrUpdateCounter(counter.toCounterEntity(groupId))
            Result.success(counterIDs.contains(counter.id))
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    override fun deleteCounters(counters: List<Counter>, groupId: UUID): Result<Unit> {
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

    private fun Counter.toCounterEntity(groupId: UUID): CounterEntity {
        return CounterEntity(id, header, text, value.v, canDecrease, groupId)
    }

    private fun CounterEntity.toCounter(): Counter {
        return Counter(id, header, text, CounterValue(value ?: -1))
    }

    private fun CounterGroupEntity.toCounterGroup(counters: List<Counter>): CounterGroup {
        return CounterGroup(id, title ?: STR_EMPTY, color, bitmapArray.toBitmap(), counters)
    }

    private fun CounterGroup.toCounterGroupEntity(): CounterGroupEntity {
        return CounterGroupEntity(id, title, color, bitmap.toByteArray())
    }

    private companion object {
        private const val STR_EMPTY = ""
    }
}