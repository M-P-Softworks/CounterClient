package com.mpsoftworks.presentation.view.main.viewmodel

import androidx.lifecycle.ViewModel
import com.mpsoftworks.domain.interactor.CounterInteractor
import com.mpsoftworks.presentation.model.main.MainListState
import com.mpsoftworks.presentation.model.main.MainScreenActions
import com.mpsoftworks.presentation.utils.toMainListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject internal constructor(
    val counterDataInteractor: CounterInteractor
) : ViewModel() {
    private val _mainListState = MutableStateFlow(defaultMainListState())
    val mainListState: StateFlow<MainListState> = _mainListState.asStateFlow()

    private val _mainListEvents = Channel<MainListState>()
    val mainListEvents: Flow<MainListState> = _mainListEvents.receiveAsFlow()

    fun onAction(action: MainScreenActions) {
        when(action){

            else -> {}
        }

    }

    private fun defaultMainListState(): MainListState {
        return MainListState()
    }

    fun onCreateVM() {
        val initialData = counterDataInteractor.getInitialData()
        _mainListState.value.copy(itemsCounterList = initialData.toMainListState().itemsCounterList)
    }
}