package com.example.viewmodeldemo2

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingCount: Int) : ViewModel() {
    private var count = 0

    init {
        count = startingCount
    }

    fun getCount(): Int {
        return count
    }

    fun updateCount(number: Int) {
        count += number
    }

}
