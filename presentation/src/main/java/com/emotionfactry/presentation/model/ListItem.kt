package com.emotionfactry.presentation.model

data class ListItem(
    val itemGroupImage: CounterGroupImage = CounterGroupImage(),
    val itemHeader: String = "Lorem Ipsum",
    val itemText: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, ",
    val itemCurrentValue: String = "100500"
)