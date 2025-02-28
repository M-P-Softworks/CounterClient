package com.mpsoftworks.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity
import java.util.UUID

/**
 * Common interface for using in counters DB
 */
@Dao
interface CountersDao {
    /**
     *
     */
    @Query("SELECT * FROM COUNTERS")
    fun getCounters(): List<CounterEntity>

    /**
     *
     */
    @Query("SELECT * FROM COUNTER_GROUP")
    fun getGroups(): List<CounterGroupEntity>

    /**
     *
     */
    @Query("SELECT * FROM COUNTERS WHERE COUNTERS.group_id = :griupID")
    fun getCurrentCounters(griupID: UUID): List<CounterEntity>

    /**
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateCounter(insert: CounterEntity)

    /**
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateGroup(insert: CounterGroupEntity)

}
