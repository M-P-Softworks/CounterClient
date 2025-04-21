package com.mpsoftworks.domain.di

import com.mpsoftworks.data.repository.RoomDbCounterRepository
import com.mpsoftworks.data.room.dao.CountersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class InteractorModule {

    @Provides
    @Singleton
    fun provideCounterDbApi(counterDao: CountersDao) =
        RoomDbCounterRepository(counterDao)

}