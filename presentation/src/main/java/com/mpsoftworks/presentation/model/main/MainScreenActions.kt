package com.mpsoftworks.presentation.model.main


sealed interface MainScreenActions {
    object IconButtonPressed: MainScreenActions

    object AddButtonPressed: MainScreenActions
}