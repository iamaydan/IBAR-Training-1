package com.example.didemo

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor(
    private val battery: Battery,
    private val simCard: SIMCard,
    private val memoryCard: MemoryCard
) {

    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailability()
        Log.i("MyTag", "SmartPhone Constructed")
    }

    fun makeACallWithRecording() {
        Log.i("MyTag", "Calling.....")
    }
}
