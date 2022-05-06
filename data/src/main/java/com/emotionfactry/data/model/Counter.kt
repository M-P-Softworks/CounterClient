package com.emotionfactry.data.model

import java.util.*

data class Counter (
    var id: UUID?,
    var title: String?,
    var value: CounterValue,
    val canDecrease: Boolean? = false,
    val isFloat: Boolean? = false
) {
    init{
        getRelevantTitle()
        setDefaultValue()
    }

    private fun getRelevantTitle(){
        if (title == null)
            this.title = title.let{"Default title"}
    }

    private fun setDefaultValue(){
        if (isFloat == true)
        value.v = 0F
        else value.v = 0L

    }
}