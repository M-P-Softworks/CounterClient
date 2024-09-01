package com.mpsoftworks.presentation.view.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.mpsoftworks.presentation.R
import com.mpsoftworks.presentation.model.main.MainScreenActions
import com.mpsoftworks.presentation.model.main.MainScreenEvents
import com.mpsoftworks.presentation.view.items.MainListItem
import com.mpsoftworks.presentation.view.main.viewmodel.MainListViewModel
import com.mpsoftworks.presentation.view.main.viewmodel.MainScreenViewModel
import com.mpsoftworks.presentation.view.theme.AppTheme
import com.mpsoftworks.presentation.view.theme.ThemeEntities
import com.mpsoftworks.presentation.view.theme.getColor
import kotlinx.coroutines.flow.Flow

/**
 * ToDo("")
 */
@Composable
internal fun MainScreen(navController: NavHostController) {
    val viewModel: MainScreenViewModel by lazy { MainScreenViewModel() }

    val state = viewModel.mainScreenState.collectAsState()
    val onAction: (MainScreenActions) -> Unit = remember { { viewModel.onAction(it) } }
    val events = viewModel.mainScreenEvents

    ObserveEvents(events)

    Scaffold(
        topBar = {
            CounterAppBar(
                navIcon = state.value.appBarIcon,
                onClick = onAction
            )
        },
        // snackbarHost = {
        //     CounterSnackBarHost()
        //                },
        floatingActionButton = {
            CounterFloatingButton(
                buttonIcon = R.drawable.ic_add,
                onAddClick = onAction
            )
        },
        floatingActionButtonPosition = FabPosition.Center

    ) { innerPadding ->
        MainScreenListContent(
            modifier = Modifier.padding(innerPadding),
            MainListViewModel()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CounterAppBar(
    modifier: Modifier = Modifier,
    onClick: (MainScreenActions) -> Unit,
    navIcon: Int
) {
    CenterAlignedTopAppBar(
        title = { AppBarTitle() },
        navigationIcon = {
            AppBarIcon(navIcon = navIcon) {
                onClick.invoke(MainScreenActions.IconButtonPressed)
            }
        }
    )
}

@Composable
private fun AppBarTitle(modifier: Modifier = Modifier) {
    Text(
        stringResource(id = R.string.main_app_name),
        style = AppTheme.typography.h5,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun AppBarIcon(
    modifier: Modifier = Modifier,
    navIcon: Int,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(navIcon),
            contentDescription = null //stringResource(id = R.string.app_icon_description)
        )
    }
}

@Composable
private fun CounterFloatingButton(
    modifier: Modifier = Modifier,
    buttonIcon: Int,
    onAddClick: (MainScreenActions) -> Unit
) {
    FloatingActionButton(
        modifier = modifier.padding(
            end = AppTheme.dimensions.paddingL,
            bottom = AppTheme.dimensions.paddingL
        ),
        onClick = { onAddClick.invoke(MainScreenActions.AddButtonPressed) },
        containerColor = ThemeEntities.BackgroundPrimary0.getColor(),
        contentColor = ThemeEntities.ElementContentPrimary0.getColor()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(buttonIcon),
            contentDescription = null
        )
    }
}

@Composable
private fun CounterSnackBarHost() {
}

@Composable
private fun ObserveEvents(events: Flow<MainScreenEvents>) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = Unit) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            events.collect {
                when (it) {
                    MainScreenEvents.ShowSideMenuBar -> TODO()
                }
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    Surface {
        // MainScreen()
    }
}

