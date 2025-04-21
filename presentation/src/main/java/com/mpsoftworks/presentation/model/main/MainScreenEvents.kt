package com.mpsoftworks.presentation.model.main

sealed interface MainScreenEvents {
    object ChangeSideMenuState : MainScreenEvents
    object NavigateToNewCounter : MainScreenEvents
    object NavigateToExistingCounter : MainScreenEvents

}