package com.emotionfactry.presentation.model.main

/**
 * Sorting status of main screen list
 * Sorting available by thee params: by group, by name and by creation time
 * @property groupSortIcon state of group icon
 * @property nameSortIcon state of name icon
 * @property timeSortIcon state of time icon
 */
data class MainListSortState (
    val groupSortIcon: SortBottonState? = null,
    val nameSortIcon: SortBottonState? = null,
    val timeSortIcon: SortBottonState? = null
)

/**
 * State of sort button
 * @property sortIcon id of sort icon resource
 * @property sortDirection id of direction icon resource
 */
data class SortBottonState (
    val sortIcon: Int,
    val sortDirection: Int
)

private val SortButtonExample = SortBottonState(
    R.
)