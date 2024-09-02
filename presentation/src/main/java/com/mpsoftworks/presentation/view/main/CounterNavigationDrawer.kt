package com.mpsoftworks.presentation.view.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mpsoftworks.presentation.R
import com.mpsoftworks.presentation.view.navigation.CounterNavDestinations
import com.mpsoftworks.presentation.view.navigation.CounterNavGraph
import com.mpsoftworks.presentation.view.navigation.Route
import com.mpsoftworks.presentation.view.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CounterNavigationDrawer(
    navController: NavHostController,
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
) {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavDrawerItem() { route ->
                    navController.navigate(route.routeString)
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            }
        }
    ) {
        CounterNavGraph(navController, drawerState)
    }
}

@Composable
private fun NavDrawerItem(onMenuClick: (Route) -> Unit) {
    // TODO("add counter groups here")
    val itemList = CounterNavDestinations.getItemsList(isForNavDrawer = true)

    Text(
        text = stringResource(id = R.string.main_app_name),
        maxLines = 1,
        style = AppTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                all = AppTheme.dimensions.paddingS
            )
    )
    Spacer(modifier = Modifier.height(AppTheme.dimensions.paddingM))
    itemList.forEach { item ->
        NavigationDrawerItem(
            label = {
                Text(
                    text = item.title,
                    maxLines = 1,
                    style = AppTheme.typography.body1,
                    textAlign = TextAlign.Left,
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = item.icon ?: 0),
                    contentDescription = null
                )
            },
            selected = false,
            onClick = { onMenuClick(item.route) })
    }
}

@Preview
@Composable
private fun NavDrawerPreview() {
    val navController = rememberNavController()
    CounterNavigationDrawer(
        navController = navController,
        drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    )
}