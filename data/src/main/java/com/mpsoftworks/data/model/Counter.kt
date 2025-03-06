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
    val id: UUID = UUID.randomUUID(),
    val title: String?,
    val value: CounterValue,
    val canDecrease: Boolean? = false,
    val isFloat: Boolean? = false
)