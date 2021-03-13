package com.example.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.livedatademo.model.UserRepository
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel : ViewModel() {
    private var usersRepository = UserRepository()

    var users = liveData(Dispatchers.IO) {
        val result = usersRepository.getUsers()
        emit(result)
    }
}