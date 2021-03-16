package com.example.didemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var smartPhone: SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val smartPhone =
//                SmartPhone(
//                        Battery(),
//                        SIMCard(ServiceProvider()),
//                        MemoryCard()
//                )
//                        .makeACallWithRecording()

        DaggerSmartPhoneComponent.create()
                .getSmartPhone()
                .makeACallWithRecording()
    }
}
