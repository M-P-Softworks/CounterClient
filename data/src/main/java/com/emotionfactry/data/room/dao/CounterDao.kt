package com.emotionfactry.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emotionfactry.data.model.Counter
import com.emotionfactry.data.model.CounterGroup
import java.util.*

@Dao
interface CounterDao {

    @Query("SELECT * FROM Counter")
    fun getCounters(): List<Counter>

    @Query("SELECT * FROM CounterGroups")
    fun getGroups(): List<CounterGroup>

    @Query("SELECT * " +
            "FROM Counter " +
            "WHERE Counter.GroupID = :groupID")
    fun getCurrentCounters(groupID: UUID): List<Counter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewCounter(insert: Counter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewCounterGroup(insert: CounterGroup)
}