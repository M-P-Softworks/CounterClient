package com.emotionfactry.presentation.model

/**
 * Item of each counter
 *
 * @property itemGroupImage every item of a counter can have a group
 * @property itemHeader header of counter item
 * @property itemText explanatory text of counter item
 * @property itemCurrentValue value of a counter item
 */
data class ListItem(
    val itemGroupImage: CounterGroupImage = CounterGroupImage(),
    val itemHeader: String = "Lorem Ipsum",
    val itemText: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, ",
    val itemCurrentValue: String = "100500"
)