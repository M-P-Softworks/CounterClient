package com.mpsoftworks.presentation.model.counter

sealed class CounterActions {
    object IncreaseCounterPressed : CounterActions()
    object DecreaseCounterPressed : CounterActions()
}