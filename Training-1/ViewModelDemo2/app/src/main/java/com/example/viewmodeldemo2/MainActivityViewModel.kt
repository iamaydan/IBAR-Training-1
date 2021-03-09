package com.example.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingCount: Int) : ViewModel() {
    private var count = MutableLiveData<Int>()
    val countData: LiveData<Int>
        get() = count

    val inputText = MutableLiveData<String>()

    init {
        count.value = startingCount
    }

    fun updateCount() {
        val number: Int = inputText.value!!.toInt()
        count.value = (count.value)?.plus(number)
    }
}