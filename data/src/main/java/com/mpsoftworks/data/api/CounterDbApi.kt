package com.mpsoftworks.data.api

import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import java.util.UUID

/**
 * API for accessing data from database
 */
interface CounterDbApi {

    /**
     * returns list of counters
     */
    fun getCounterList(counterGroupId: UUID): List<Counter>

    /**
     * add new counter if [counter] does not exists, otherwise update existing.
     * @return Returns true if new counter was added
     */
    fun addOrUpdateCounter(counter: Counter, group: CounterGroup): Boolean

    /**
     * delete existing [counters]
     */
    fun deleteCounter(counters: List<Counter>, group: CounterGroup)

    //---------------------------------------------------------------------------------------------

    /**
     * returns list of counter groups
     */
    fun getGroups(): List<CounterGroup>

    /**
     * add new group of counters if [group] does not exists, otherwise update existing.
     * @return Returns true if new counter was added
     */
    fun addOrUpdateGroup(group: CounterGroup): Boolean

    /**
     * delete existing [groups]
     */
    fun deleteGroup(groups: List<CounterGroup>)

}