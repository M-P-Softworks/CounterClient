package com.emotionfactry.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emotionfactry.data.room.entity.CounterEntity
import com.emotionfactry.data.room.entity.CounterGroupEntity

@Database(entities = [CounterEntity::class,
                        CounterGroupEntity::class],
                        version = 1)
internal abstract class AppDatabase : RoomDatabase() {

}