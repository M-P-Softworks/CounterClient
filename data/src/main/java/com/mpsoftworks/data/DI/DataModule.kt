/*
package com.mpsoftworks.data.DI

import com.mpsoftworks.data.room.CounterDB
import com.mpsoftworks.data.room.dao.CounterDao
import com.mpsoftworks.data.usecase.CounterUseCase
import com.mpsoftworks.data.usecase.implementation.CounterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DataModule {

    @Provides
    @Singleton
    fun provideCounterDao(db: CounterDB): CounterDao  = db.counterDao()
}*/
