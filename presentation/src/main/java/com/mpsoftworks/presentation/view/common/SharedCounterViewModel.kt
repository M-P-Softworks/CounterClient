package com.mpsoftworks.presentation.view.common

import com.mpsoftworks.model.Counter
import com.mpsoftworks.model.CounterGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
class SharedCounterViewModel : ViewModel() {

    private val _selectedCounter = MutableStateFlow(Counter())
    private val _selectedGroup = MutableStateFlow(CounterGroup())

    /**
     *
     */
    val selectedCounter: StateFlow<Counter> = _selectedCounter.asStateFlow()

    /**
     *
     */
    val selectedGroup: StateFlow<CounterGroup> = _selectedGroup.asStateFlow()

    /**
     *
     */
    fun selectCounter(counter: Counter) {
        viewModelScope.launch {
            _selectedCounter.emit(counter)
        }
    }

    /**
     *
     */
    fun selectGroup(group: CounterGroup) {
        viewModelScope.launch {
            _selectedGroup.emit(group)
        }
    }
}