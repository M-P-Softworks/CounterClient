package com.mpsoftworks.presentation.view.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mpsoftworks.presentation.view.counter.CounterScreen
import com.mpsoftworks.presentation.view.main.MainScreen
import com.mpsoftworks.presentation.view.settings.SettingsScreen

@Composable
fun CounterNavGraph(
navController: NavHostController,
drawerState: DrawerState
) {
   NavHost(
       navController = navController,
       startDestination = CounterNavDestinations.MainScreen.route.routeString
   ){
       addMainScreen(navController, this, drawerState)
       addCounterScreen(navController, this)
       addSettingsScreen(navController, this)
       addAboutScreen(navController, this)

   }
}

private fun addMainScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    drawerState: DrawerState
) {
    navGraphBuilder.composable(route = CounterNavDestinations.MainScreen.route.routeString) {
        MainScreen(navController, drawerState)
    }
}

private fun addCounterScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = CounterNavDestinations.CounterScreen.route.routeString) {
        CounterScreen(navController)
    }
}

private fun addSettingsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = CounterNavDestinations.SettingsScreen.route.routeString) {
        SettingsScreen(navController)
    }
}

private fun addAboutScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = CounterNavDestinations.AboutScreen.route.routeString) {

    }
}