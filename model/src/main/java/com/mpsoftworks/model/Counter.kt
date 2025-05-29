package com.mpsoftworks.model

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Class contains counter details in app
 *
 * @property id UUID identified each counter
 * @property header counter title
 * @property counterValue counter value
 * @property canDecrease can value be decreased
 * @property isFloat is counter value float
 */
@OptIn(ExperimentalUuidApi::class)
data class Counter (
    val id: Uuid = Uuid.NIL,
    val header: String? = null,
    val text: String? = null,
    val counterValue: CounterValue = CounterValue(0),
    val canDecrease: Boolean? = false,
    val isFloat: Boolean = false
)