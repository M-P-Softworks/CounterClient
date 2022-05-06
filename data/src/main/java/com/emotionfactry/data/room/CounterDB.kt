package com.emotionfactry.data.room

import androidx.room.*
import com.emotionfactry.data.model.Counter
import com.emotionfactry.data.model.CounterGroup
import com.emotionfactry.data.room.dao.CounterDao
import com.emotionfactry.data.room.entity.CounterEntity
import com.emotionfactry.data.room.entity.CounterGroupEntity

@Database(entities = [CounterEntity::class,
                        CounterGroupEntity::class],
                        version = 1)
internal abstract class CounterDB : RoomDatabase() {

    abstract fun counterDao(): CounterDao
}