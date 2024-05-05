package com.emotionfactry.presentation.model.main


sealed interface MainScreenActions {
    object IconButtonPressed: MainScreenActions

    object AddButtonPressed: MainScreenActions
}