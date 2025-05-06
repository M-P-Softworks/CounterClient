package com.mpsoftworks.data.model

import android.graphics.Bitmap
import java.util.*
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
    val id: Uuid,
    val title:String,
    val color: Int,
    val bitmap: Bitmap,
    val listCounter: List<Counter>?
)
