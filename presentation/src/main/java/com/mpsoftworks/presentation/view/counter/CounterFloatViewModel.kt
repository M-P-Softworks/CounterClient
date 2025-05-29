package com.mpsoftworks.presentation.view.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpsoftworks.domain.interactor.CounterInteractor
import com.mpsoftworks.domain.model.CounterDataHolder
import com.mpsoftworks.presentation.model.counter.CounterActions
import com.mpsoftworks.presentation.model.counter.CounterScreenEvents
import com.mpsoftworks.presentation.model.counter.CounterScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.uuid.ExperimentalUuidApi

@HiltViewModel
class CounterFloatViewModel @Inject internal constructor(
    val counterDataInteractor: CounterInteractor,
    val counterDataHolder: CounterDataHolder
) : ViewModel() {
    private val _counterScreenState = MutableStateFlow(defaultCounterScreenState())
    val counterScreenState: StateFlow<CounterScreenState> = _counterScreenState.asStateFlow()

    private val _events = Channel<CounterScreenEvents>()
    val counterEvents: Flow<CounterScreenEvents> = _events.receiveAsFlow()

    fun onAction(action: CounterActions) {
        when (action) {
            CounterActions.IncreaseCounterPressed -> increaseValue()
            else -> {}
        }
    }

    private fun defaultCounterScreenState(): CounterScreenState {
        return CounterScreenState()
    }

    @OptIn(ExperimentalUuidApi::class)
    fun increaseValue() {
        viewModelScope.launch {
            counterDataHolder.selectedCounter.value.counterValue.copy(
                v = counterDataHolder.selectedCounter.value.counterValue.v.toLong() + 1
            )
            counterDataInteractor.updateCounterValue(
                counterDataHolder.selectedCounter.value,
                counterDataHolder.selectedGroup.value.id
            )
        }
    }

    private fun sendEvent(event: CounterScreenEvents) = viewModelScope.launch {
        _events.trySend(event)
    }
}
