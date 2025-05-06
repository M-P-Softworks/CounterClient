package com.mpsoftworks.data.model

import java.util.*
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Class contains counter details in app
 *
 * @property id UUID identified each counter
 * @property header counter title
 * @property value counter value
 * @property canDecrease can value be decreased
 * @property isFloat is counter value float
 */
@OptIn(ExperimentalUuidApi::class)
data class Counter (
    val id: Uuid = Uuid.random(),
    val header: String?,
    val text: String?,
    val value: CounterValue,
    val canDecrease: Boolean? = false,
    val isFloat: Boolean? = false
)