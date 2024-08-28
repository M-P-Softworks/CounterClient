package com.emotionfactry.presentation.view.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.emotionfactry.presentation.model.main.MainListState
import com.emotionfactry.presentation.view.items.MainListItem
import com.emotionfactry.presentation.view.main.viewmodel.MainListViewModel
import com.emotionfactry.presentation.view.theme.AppTheme

@Composable
internal fun MainScreenListContent(
    modifier: Modifier = Modifier,
    viewModel: MainListViewModel
) {
    val state = viewModel.mainListState.collectAsState()
    val events = viewModel.mainListEvents

    val onClick = remember {
        {}
    }

    Column(modifier = modifier) {
        MainScreenList(
            state = state.value,
            onClick = onClick
        )
        ListSettings()
    }
}

@Composable
private fun MainScreenList(
    state: MainListState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppTheme.dimensions.paddingM)
    ) {
        items(state.itemsCounterList) { item ->
            MainListItem(
                modifier = modifier
                    .clickable(
                        enabled = true,
                        role = Role.Button,
                        onClick = onClick
                    ),
                listItem = item
            )
            Spacer(modifier = Modifier.padding(top = AppTheme.dimensions.paddingS))
        }
    }
}

@Composable
private fun ListSettings(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        //Group sorting
        Button(onClick = { /*TODO*/ }) {
            Text(text = "GROUP")
        }

        //Name sorting
        Button(onClick = { /*TODO*/ }) {
            Text(text = "NAME")

        }

        //Time sorting
        Button(onClick = {  /*TODO*/ }) {
            Text(text = "TIME")

        }
    }
}

@Preview
@Composable
private fun PreviewList() {
    MainScreenListContent(
        viewModel = MainListViewModel()
    )
}