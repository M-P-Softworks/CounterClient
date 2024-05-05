package com.emotionfactry.presentation.model.main

import com.emotionfactry.presentation.model.ListItem

/**
 * Main screen state
 * @property itemsCounterList counter list of all counters
 * @property listSortState sort state
 */
data class MainListState(
    val itemsCounterList: List<ListItem> = itemList,
    val listSortState: MainListSortState? = null
)

private val itemList: List<ListItem> = listOf(
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem(),
    ListItem()

)