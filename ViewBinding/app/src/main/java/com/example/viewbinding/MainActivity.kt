package com.example.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            displayGreeting()
        }
    }

    private fun displayGreeting() {
        binding.apply {
            greetingTextView.text = "Hello! " + nameEditText.text
        }

    }
}