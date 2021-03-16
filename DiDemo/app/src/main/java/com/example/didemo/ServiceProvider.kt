package com.example.didemo

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {
    init {
        Log.i("MyTag", "Service Provider Constructed")
    }

    fun getServiceProvider() {
        Log.i("MyTag", "Service provider connected")
    }
}