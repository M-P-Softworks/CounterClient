package com.mpsoftworks.presentation.view.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpsoftworks.domain.interactor.CounterInteractor
import com.mpsoftworks.presentation.model.counter.CounterActions
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

@HiltViewModel
class CounterScreenViewModel @Inject internal constructor(
    val counterDataInteractor: CounterInteractor
) : ViewModel() {
    private val _counterScreenState = MutableStateFlow(defaultCounterScreenState())
    val counterScreenState: StateFlow<CounterScreenState> = _counterScreenState.asStateFlow()

    private val _actions = Channel<CounterActions>()
    val counterActions: Flow<CounterActions> = _actions.receiveAsFlow()

    fun onAction(action: CounterActions) {
        when (action) {
            CounterActions.IncreaseCounterPressed -> increaseValue()
            CounterActions.DecreaseCounterPressed -> decreaseValue()
        }
    }

    private fun defaultCounterScreenState(): CounterScreenState {
        return CounterScreenState()
    }

    private fun increaseValue() {

    }

    private fun decreaseValue() {

    }

    private fun sendEvent(event: CounterActions) = viewModelScope.launch {
        _actions.trySend(event)
    }
}