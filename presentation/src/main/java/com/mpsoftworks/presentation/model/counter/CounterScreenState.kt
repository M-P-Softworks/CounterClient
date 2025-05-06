package com.mpsoftworks.presentation.model.counter

import androidx.compose.foundation.gestures.Orientation
import com.mpsoftworks.presentation.model.CounterValue

/**
 * Class contains counter details in app
 *
 * @property counterValue counter value
 * @property canDecrease can value be decreased
 * @property isFloat is counter value float
 */
data class CounterScreenState (
    val counterValue: CounterValue = CounterValue(0),
    val canDecrease: Boolean = false,
    val isFloat: Boolean = false,
    val orientation: Orientation = Orientation.Vertical
)