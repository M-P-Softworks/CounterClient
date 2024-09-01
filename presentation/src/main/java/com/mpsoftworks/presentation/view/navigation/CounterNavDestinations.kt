package com.mpsoftworks.presentation.view.navigation

import com.mpsoftworks.presentation.R

sealed class CounterNavDestinations(
    val title: String,
    val route: Route,
    val icon: Int? = null
) {
    object MainScreen: CounterNavDestinations (
        title = "Counters",
        route = Route("mainScreen"),
        icon = R.drawable.ic_settings
    )

    object CounterScreen: CounterNavDestinations (
        title = "Counter",
        route = Route("counterScreen")
    )

    object SettingsScreen: CounterNavDestinations(
        title = "Settings",
        route = Route("settingsScreen"),
        icon = R.drawable.ic_gear
    )

    object AboutScreen: CounterNavDestinations(
        title = "About",
        route = Route("aboutScreen"),
        icon = R.drawable.ic_about
    )

    companion object {
        fun getItemsList(isForNavDrawer: Boolean): List<CounterNavDestinations> {
            val result = mutableListOf(MainScreen, SettingsScreen, AboutScreen)

            if (!isForNavDrawer) result.add(CounterScreen)
            return result.toList()
        }
    }
}

@JvmInline
value class Route(val routeString: String)