package com.emotionfactry.data.repository.Implementation

import com.emotionfactry.data.model.Counter
import com.emotionfactry.data.model.CounterGroup
import com.emotionfactry.data.repository.CounterDBRepository
import com.emotionfactry.data.room.dao.CounterDao
import java.util.*
import javax.inject.Inject

class CounterDBRepoImpl @Inject constructor(private val counterDao: CounterDao) : CounterDBRepository {
    override fun getCountersForGroup(group: CounterGroup): List<Counter> {
       // counterDao.getCurrentCounters()
        TODO("Not yet implemented")
    }

    override fun inputCounter(counter: Counter) {
        TODO("Not yet implemented")
    }

    override fun getGroups(): List<CounterGroup> {
        TODO("Not yet implemented")
    }

    override fun inputEmptyGroup(group: CounterGroup) {
        TODO("Not yet implemented")
    }
}