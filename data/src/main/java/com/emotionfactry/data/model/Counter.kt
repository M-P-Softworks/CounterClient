package com.emotionfactry.data.model

data class Counter (
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