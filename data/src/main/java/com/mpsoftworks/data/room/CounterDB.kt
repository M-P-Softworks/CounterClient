package com.mpsoftworks.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mpsoftworks.data.room.dao.CountersDao
import com.mpsoftworks.data.room.entity.CounterEntity
import com.mpsoftworks.data.room.entity.CounterGroupEntity

@Database(entities = [CounterEntity::class, CounterGroupEntity::class], version = 1)
abstract class CountersDB : RoomDatabase() {
    abstract fun countersDao(): CountersDao

    companion object {
        @Volatile
        private var INSTANCE: CountersDB? = null

        fun getDB(context: Context): CountersDB {
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
