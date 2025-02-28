package com.mpsoftworks.data.model

import java.util.*

/**
 * Class contains counter group details
 * @property id UUID identified each group
 * @property title group title
 * @property color group color
 * @property listCounter list of counters current group
 */
data class CounterGroup(
    val id: UUID,
    val title:String,
    val color: Int,
    val listCounter: List<Counter>?
)
