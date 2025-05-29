package com.mpsoftworks.presentation.model.counter

sealed interface CounterScreenEvents {
    object ChangeCounterScreenState : CounterScreenEvents
    object NavigateToCounterSettings : CounterScreenEvents
    object NavigateToMainScreen : CounterScreenEvents
}