package com.emotionfactry.data.repository.Implementation

import com.emotionfactry.data.model.Counter
import com.emotionfactry.data.model.CounterGroup
import com.emotionfactry.data.repository.CounterDBRepository
import com.emotionfactry.data.room.dao.CounterDao
import java.util.*
import javax.inject.Inject

class CounterDBRepoImpl @Inject constructor(private val counterDao: CounterDao) : CounterDBRepository {
    override fun getCountersForGroup(group: CounterGroup): List<Counter> {
        val x = counterDao.getCurrentCounters(group.id)
        return listOf<Counter>().apply { }
    }

    override fun inputCounter(counter: Counter) {
        counterDao.insertNewCounter(counter)
    }

    override fun getGroups(): List<CounterGroup> {
        return counterDao.getGroups()
    }

    override fun inputEmptyGroup(group: CounterGroup) {
        counterDao.insertNewCounterGroup(group)
    }
}