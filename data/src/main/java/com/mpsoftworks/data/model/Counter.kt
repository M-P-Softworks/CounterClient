package com.mpsoftworks.data.model

import java.util.*

/**
 * Class contains counter details in app
 *
 * @property id UUID identified each counter
 * @property title counter title
 * @property value counter value
 * @property canDecrease can value be decreased
 * @property isFloat is counter value float
 */
data class Counter (
    var id: UUID = UUID.randomUUID(),
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
