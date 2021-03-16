package com.example.didemo

import android.util.Log

class Battery {
    init {
        Log.i("MyTag", "Battery Constructed")
    }

    fun getPower() {
        Log.i("MyTag", "Battery power is available")
    }
}
