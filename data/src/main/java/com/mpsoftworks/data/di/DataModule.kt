package com.mpsoftworks.data.di

import android.content.Context
import android.util.Log
import com.mpsoftworks.data.room.CountersDB
import com.mpsoftworks.data.room.dao.CountersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal class DataModule {

    // provides room DB to repository
    @Provides
    @Singleton
    fun provideRoomData(db: CountersDB): CountersDao = db.countersDao()

    //provides DB
    @Provides
    @Singleton
    fun provideCountersDB(
        @ApplicationContext context: Context
    ): CountersDB {
        val res = CountersDB.getInstance(context)
        return res
    }
}
