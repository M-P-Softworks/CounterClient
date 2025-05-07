package com.mpsoftworks.model

/**
 * Class, contains all data of Counters.
 */
data class InitialCountersData(
    val groups: List<CounterGroup>,
    val counters: List<List<Counter>>
)
