package com.mpsoftworks.data.repository

import com.mpsoftworks.data.api.CounterDbApi
import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import com.mpsoftworks.data.model.CounterValue
import com.mpsoftworks.data.room.dao.CountersDao
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity
import java.util.UUID
import javax.inject.Inject

/**
 *
 */
class  RoomDbCounterRepository @Inject constructor(private val counterDao: CountersDao) :
    CounterDbApi {

    override fun getCounterList(counterGroupId: UUID): List<Counter> {
        return counterDao.getCurrentCounters(counterGroupId).map { entity ->
            entity.toCounter()
        }
    }

    override fun addOrUpdateCounter(counter: Counter, group: CounterGroup): Boolean {
        val counterIDs = counterDao.getCurrentCounters(group.id).map { entity ->
            entity.id
        }
        counterDao.insertOrUpdateCounter(counter.toCounterEntity(group))
        return counterIDs.contains(counter.id)
    }

    override fun deleteCounter(counters: List<Counter>, group: CounterGroup) {
        counterDao.deleteCounterList(counters.map { entity ->
            entity.toCounterEntity(group)
        })
    }

    override fun getGroups(): List<CounterGroup> {

        return counterDao.getGroups()
            .map { entity -> entity.toCounterGroup(getCounterList(entity.id)) }
    }

    override fun addOrUpdateGroup(group: CounterGroup): Boolean {
        val groupIDs = counterDao.getGroups().map { entity ->
            entity.id
        }
        counterDao.insertOrUpdateGroup(group.toCounterGroupEntity())
        return groupIDs.contains(group.id)
    }

    override fun deleteGroup(groups: List<CounterGroup>) {
        counterDao.deleteGroupList(groups.map { entity ->
            entity.toCounterGroupEntity()
        })
    }

    //---------------------------------------------------------------------------------------------

    private fun Counter.toCounterEntity(group: CounterGroup): CounterEntity {
        return CounterEntity(id, title, value.v, canDecrease, group.id)
    }

    private fun CounterEntity.toCounter(): Counter {
        return Counter(id, title, CounterValue(value ?: -1))
    }

    private fun CounterGroupEntity.toCounterGroup(counters: List<Counter>): CounterGroup {
        return CounterGroup(id, title ?: STR_EMPTY, color, counters)
    }

    private fun CounterGroup.toCounterGroupEntity(): CounterGroupEntity {
        return CounterGroupEntity(id, title, color)
    }

    private companion object {
        private const val STR_EMPTY = ""
    }
}