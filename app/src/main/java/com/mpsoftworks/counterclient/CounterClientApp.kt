package com.mpsoftworks.counterclient

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CounterClientApp : Application() {

    init{
        setDefaultDBValues()
    }

    private fun setDefaultDBValues(){

    }

//    ToDo("create initializer. ")
}