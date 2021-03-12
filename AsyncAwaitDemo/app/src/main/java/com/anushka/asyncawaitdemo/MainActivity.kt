package com.anushka.asyncawaitdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MyTag", "Calculation started....")

            val stock1 = async(IO) {
                getStock1()
            }
            val stock2 = async(IO) {
                getStock2()
            }

            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext, "Total : $total", Toast.LENGTH_SHORT).show()

        }

    }
}

private suspend fun getStock1(): Int {
    delay(10000)
    Log.i("MyTag", " stock 1 returned ")
    return 55000
}

private suspend fun getStock2(): Int {
    delay(8000)
    Log.i("MyTag", " stock 2 returned ")
    return 35000
}