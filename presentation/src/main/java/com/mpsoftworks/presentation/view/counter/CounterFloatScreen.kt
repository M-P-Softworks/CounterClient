package com.mpsoftworks.presentation.view.counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
internal fun CounterFloatScreen(
    navController: NavHostController
) {
    val viewModel = hiltViewModel<CounterFloatViewModel>()

    val state = viewModel.counterScreenState.collectAsState()
}
