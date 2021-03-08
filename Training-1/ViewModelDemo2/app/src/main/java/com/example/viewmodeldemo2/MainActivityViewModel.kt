package com.example.viewmodeldemo2

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var count = 0

    fun getCount(): Int {
        return count
    }

    fun updateCount(number: Int) {
        count += number
    }

}
