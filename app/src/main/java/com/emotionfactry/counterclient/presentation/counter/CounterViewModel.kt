package com.emotionfactry.counterclient.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _counterValue: MutableLiveData<Long> = MutableLiveData()
    val counterValue: LiveData<Long> = _counterValue

    fun  incrementValue(){

    }

    fun decrementValue(){

    }
    fun updateValue(){

    }
}