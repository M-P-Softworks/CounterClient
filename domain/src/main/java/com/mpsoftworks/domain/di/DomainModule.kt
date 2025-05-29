package com.mpsoftworks.domain.di

import com.mpsoftworks.data.api.CounterDbApi
import com.mpsoftworks.data.repository.RoomDbCounterRepository
import com.mpsoftworks.data.room.dao.CountersDao
import com.mpsoftworks.domain.model.CounterDataHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DomainModule {

    @Provides
    @Singleton
    fun provideCounterDbApi(counterDao: CountersDao): CounterDbApi =
        RoomDbCounterRepository(counterDao)
}