package com.mpsoftworks.data.api

import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import java.util.UUID
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * API for accessing data from database
 */
interface CounterDbApi {

    /**
     * returns list of counters
     */
    @OptIn(ExperimentalUuidApi::class)
    fun getCounterList(counterGroupId: Uuid): Result<List<Counter>>

    /**
     * add new counter if [counter] does not exists, otherwise update existing.
     * @return Returns true if new counter was added
     */
    @OptIn(ExperimentalUuidApi::class)
    fun addOrUpdateCounter(counter: Counter, groupId: Uuid): Result<Boolean>

    /**
     * delete existing [counters]
     */
    @OptIn(ExperimentalUuidApi::class)
    fun deleteCounters(counters: List<Counter>, groupId: Uuid): Result<Unit>

    //---------------------------------------------------------------------------------------------

    /**
     * returns list of counter groups
     */
    fun getGroups(): Result<List<CounterGroup>>

    /**
     * add new group of counters if [group] does not exists, otherwise update existing.
     * @return Returns true if new counter was added
     */
    fun addOrUpdateGroup(group: CounterGroup): Result<Boolean>

    /**
     * delete existing [groups]
     */
    fun deleteGroup(groups: List<CounterGroup>): Result<Unit>

}