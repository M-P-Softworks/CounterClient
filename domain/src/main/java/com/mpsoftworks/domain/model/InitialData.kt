package com.mpsoftworks.domain.model

import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import java.security.acl.Group

/**
 * Class, contains all data of Counters.
 */
data class InitialCountersData(
    val groups: List<CounterGroup>,
    val counters: List<List<Counter>>
)
