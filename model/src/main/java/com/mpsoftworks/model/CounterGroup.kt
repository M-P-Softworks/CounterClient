package com.mpsoftworks.model

import android.graphics.Bitmap
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Class contains counter group details
 * @property id UUID identified each group
 * @property title group title
 * @property color group color
 * @property listCounter list of counters current group
 */
@OptIn(ExperimentalUuidApi::class)
data class CounterGroup(
    val id: Uuid = Uuid.NIL,
    val title:String = "",
    val color: Int = 0,
    val bitmap: Bitmap? = null,
    val listCounter: List<Counter>? = null
)
