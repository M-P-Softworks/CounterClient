package com.emotionfactry.presentation.view.main.viewmodel

import com.emotionfactry.presentation.model.main.MainListState
import com.emotionfactry.presentation.model.main.MainScreenActions
import com.emotionfactry.presentation.model.main.MainScreenEvents
import com.emotionfactry.presentation.model.main.MainScreenState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class MainListViewModel(

) {
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
}