package com.emotionfactry.counterclient.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emotionfactry.data.usecase.CounterUseCase
import javax.inject.Inject

class CounterViewModel @Inject constructor(
    private val counterUseCase: CounterUseCase
) : ViewModel() {

    private val _counterValue: MutableLiveData<Long> = MutableLiveData()
    val counterValue: LiveData<Long> = _counterValue

    fun  incrementValue(){
    }

    fun decrementValue(){
        counterUseCase.increment()
    }

    fun updateValue(){

    }
}