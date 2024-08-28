/*
package com.mpsoftworks.data.repository.Implementation

import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import com.mpsoftworks.data.model.CounterValue
import com.mpsoftworks.data.repository.CounterDBRepository
import com.mpsoftworks.data.room.dao.CounterDao
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity
import java.util.*
import javax.inject.Inject

class CounterDBRepoImpl @Inject constructor(private val counterDao: CounterDao) : CounterDBRepository {

    override fun getCountersForGroup(group: CounterGroup): List<Counter> {
        val resList = mutableListOf<Counter>()
        val x = counterDao.getCurrentCounters(group.id)
        x.forEach {
            Counter(it.id, it.title, CounterValue(it.value),
                it.canDecrease, )
//            resList.add(
//            )
        }
        return listOf<Counter>().apply { }
    }

    override fun inputCounter(counter: Counter) {
        TODO("Not yet implemented")
    }

    fun inputCounter(counter: Counter, group: CounterGroup) {
        counterDao.insertNewCounter(counter.toCounterEntity(group))
    }

    override fun getGroups(): List<CounterGroup> {
        counterDao.getGroups()
        return emptyList()
    }

    override fun inputEmptyGroup(group: CounterGroup) {
//        counterDao.insertNewCounterGroup(group)
    }

    //------- private methods -------------------------------------------------------

    private fun Counter.toCounterEntity(group: CounterGroup): CounterEntity{
        return CounterEntity(id,title, value.v, canDecrease, group.id)
    }

    private fun CounterEntity.toCounter(): Counter{
        return Counter(id, title, CounterValue(value!!),  )
    }

    private fun CounterGroupEntity.toCounterGroup(): CounterGroup{
        TODO("Not yet implemented")
//        return CounterGroup(id,title, )
    }

    private fun isFloat(n: Number): Boolean{
        return false


    }
}*/
