/*
package com.mpsoftworks.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity
import java.util.*

@Dao
interface CounterDao {

    @Query("SELECT * FROM Counter")
    fun getCounters(): List<CounterEntity>

    @Query("SELECT * FROM CounterGroups")
    fun getGroups(): List<CounterGroupEntity>

    @Query("SELECT * " +
            "FROM Counter " +
            "WHERE Counter.GroupID = :groupID")
    fun getCurrentCounters(groupID: UUID): List<CounterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewCounter(insert: CounterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewCounterGroup(insert: CounterGroupEntity)
}*/
