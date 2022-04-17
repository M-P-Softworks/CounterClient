package com.emotionfactry.counterclient.presentation.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.emotionfactry.data.usecase.CounterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val counterUseCase: CounterUseCase
): ViewModel(), LifecycleOwner {

    override fun getLifecycle(): Lifecycle {
        return lifecycle
    }
}