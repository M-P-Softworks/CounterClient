package com.mpsoftworks.domain.model

import com.mpsoftworks.model.Counter
import com.mpsoftworks.model.CounterGroup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.uuid.ExperimentalUuidApi

@Singleton
@OptIn(ExperimentalUuidApi::class)
class CounterDataHolder @Inject constructor() {

    private val _selectedCounter = MutableStateFlow(Counter())
    private val _selectedGroup = MutableStateFlow(CounterGroup())

    /**
     * Stores user selected counter
     */
    val selectedCounter: StateFlow<Counter> = _selectedCounter.asStateFlow()

    /**
     * Stores user selected counter group
     */
    val selectedGroup: StateFlow<CounterGroup> = _selectedGroup.asStateFlow()

    /**
     * Updates user selected counter
     */
    suspend fun selectCounter(counter: Counter) {
        _selectedCounter.emit(counter)
    }

    /**
     * Updates user selected counter group
     */
    suspend fun selectGroup(group: CounterGroup) {
        _selectedGroup.emit(group)
    }
}