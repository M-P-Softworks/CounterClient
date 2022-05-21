package com.emotionfactry.data.repository.Implementation

import com.emotionfactry.data.model.Counter
import com.emotionfactry.data.model.CounterGroup
import com.emotionfactry.data.model.CounterValue
import com.emotionfactry.data.repository.CounterDBRepository
import com.emotionfactry.data.room.dao.CounterDao
import com.emotionfactry.data.room.entity.CounterEntity
import com.emotionfactry.data.room.entity.CounterGroupEntity
import java.util.*
import javax.inject.Inject

class CounterDBRepoImpl @Inject constructor(private val counterDao: CounterDao) : CounterDBRepository {

    override fun getCountersForGroup(group: CounterGroup): List<Counter> {
        val resList = mutableListOf<Counter>()
        val x = counterDao.getCurrentCounters(group.id)
        x.forEach { it. }
        return listOf<Counter>().apply { }
    }

    override fun inputCounter(counter: Counter, group: CounterGroup) {
        counterDao.insertNewCounter(counter.toCounterEntity(group))
    }

    override fun getGroups(): List<CounterGroup> {
        return counterDao.getGroups()
    }

    override fun inputEmptyGroup(group: CounterGroup) {
        counterDao.insertNewCounterGroup(group)
    }

    //------- private methods -------------------------------------------------------

    private fun Counter.toCounterEntity(group: CounterGroup): CounterEntity{
        return CounterEntity(id,title, value.v, canDecrease, group.id)
    }

    private fun CounterEntity.toCounter(): Counter{
        return Counter(id, title, CounterValue(value!!),  )
    }

    private fun CounterGroupEntity.toCounterGroup(): CounterGroup{
        return CounterGroup(id,title,color,)
    }

    private fun isDouble(n: Number){

    }
}