package com.mpsoftworks.presentation.view.main.viewmodel

import android.service.autofill.UserData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mpsoftworks.presentation.model.main.MainScreenActions
import com.mpsoftworks.presentation.model.main.MainScreenEvents
import com.mpsoftworks.presentation.model.main.MainScreenState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class MainScreenViewModel(
    // val userData: UserDataRepository
) : ViewModel() {

    private val _mainScreenState = MutableStateFlow(defaultMainScreenState())
    val mainScreenState: StateFlow<MainScreenState> = _mainScreenState.asStateFlow()

    private val _mainScreenEvents = Channel<MainScreenEvents>()
    val mainScreenEvents: Flow<MainScreenEvents> = _mainScreenEvents.receiveAsFlow()

    fun onAction(action: MainScreenActions) {
        when(action){

            else -> {}
        }

    }

    private fun defaultMainScreenState(): MainScreenState {
        return MainScreenState(
            userId = "userData"
        )
    }
}