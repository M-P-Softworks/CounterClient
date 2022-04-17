package com.emotionfactry.data.DI

import com.emotionfactry.data.room.CounterDB
import com.emotionfactry.data.room.dao.CounterDao
import com.emotionfactry.data.usecase.CounterUseCase
import com.emotionfactry.data.usecase.implementation.CounterImpl
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
}