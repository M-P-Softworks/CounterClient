package com.mpsoftworks.presentation.view.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpsoftworks.presentation.model.main.MainScreenActions
import com.mpsoftworks.presentation.model.main.MainScreenEvents
import com.mpsoftworks.presentation.model.main.MainScreenState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    // val userData: UserDataRepository
) : ViewModel() {

    private val _mainScreenState = MutableStateFlow(defaultMainScreenState())
    private val _events = Channel<MainScreenEvents>()

    val mainScreenState: StateFlow<MainScreenState> = _mainScreenState.asStateFlow()
    val mainScreenEvents: Flow<MainScreenEvents> = _events.receiveAsFlow()

    fun onAction(action: MainScreenActions) {
        when(action){
            MainScreenActions.AddButtonPressed -> sendEvent(MainScreenEvents.NavigateToExistingCounter)
            MainScreenActions.IconButtonPressed -> sendEvent(MainScreenEvents.ChandeSideMenuState)
        }

    }

    private fun sendEvent(event: MainScreenEvents) = viewModelScope.launch {
        _events.send(event)
    }

    private fun defaultMainScreenState(): MainScreenState {
        return MainScreenState(
            userId = "userData"
        )
    }
}