package com.example.didemo

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(
    val battery: Battery,
    val simCard: SIMCard,
    val memoryCard: MemoryCard
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

