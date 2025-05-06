package com.mpsoftworks.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mpsoftworks.data.room.dao.CountersDao
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity
import com.mpsoftworks.data.room.util.Converters

@Database(entities = [CounterEntity::class, CounterGroupEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class CountersDB : RoomDatabase() {
    abstract fun countersDao(): CountersDao

    companion object {
        @Volatile
        private var INSTANCE: CountersDB? = null

        @JvmStatic
        fun getInstance(context: Context): CountersDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountersDB::class.java,
                    "counters_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
