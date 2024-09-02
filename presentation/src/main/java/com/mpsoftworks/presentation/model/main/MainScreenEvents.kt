package com.mpsoftworks.presentation.model.main

sealed interface MainScreenEvents {
    object ChandeSideMenuState : MainScreenEvents
    object NavigateToNewCounter : MainScreenEvents
    object NavigateToExistingCounter : MainScreenEvents

}