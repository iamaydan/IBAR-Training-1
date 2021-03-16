package com.example.didemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        SmartPhone(
                Battery(),
                SIMCard(ServiceProvider()),
                MemoryCard()
        )
                .makeACallWithRecording()


    }
}
