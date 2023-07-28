package com.emotionfactry.data.usecase

import com.emotionfactry.data.model.Counter

interface CounterUseCase {
    fun increment(): Unit
    fun decrement(): Unit
    fun update(): Unit
}