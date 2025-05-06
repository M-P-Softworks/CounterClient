package com.mpsoftworks.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Common interface for using in counters DB
 */
@Dao
interface CountersDao {
    /**
     * Get all created counters
     */
    @Query("SELECT * FROM counters")
    fun getCounters(): List<CounterEntity>

    /**
     * Get all created groups
     */
    @Query("SELECT * FROM counter_group")
    fun getGroups(): List<CounterGroupEntity>

    //TODO("remake using custom sql query with counterID s")
    /**
     * Delete list of [counters]
     */
    @Delete
    fun deleteCounterList(counters: List<CounterEntity>)

    /**
     * Get list of counters from selected [groupID]
     */
    @OptIn(ExperimentalUuidApi::class)
    @Query("SELECT * FROM counters WHERE counters.group_id = :groupID")
    fun getCurrentCounters(groupID: Uuid): List<CounterEntity>

    /**
     * Insert new or udates existing counter [entity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateCounter(entity: CounterEntity)

    /**
     * Insert new or updates existing group [entity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateGroup(entity: CounterGroupEntity)

    //TODO("remake using custom sql query with groupsID s")
    /**
     * Delete list of [groups]
     */
    @Delete
    fun deleteGroupList(groups: List<CounterGroupEntity>)
}
