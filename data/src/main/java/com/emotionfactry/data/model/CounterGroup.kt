package com.emotionfactry.data.model

data class CounterGroup(
    public val title:String,
    public val color: Int,
    public val listCounter: List<Counter>?
)