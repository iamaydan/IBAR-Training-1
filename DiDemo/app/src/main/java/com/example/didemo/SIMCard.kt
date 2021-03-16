package com.example.didemo

import android.util.Log

class SIMCard(private val serviceProvider: ServiceProvider) {


    init {
        Log.i("MyTag", "SIM Card Constructed")
    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}