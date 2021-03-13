package com.anushka.coroutinesdemo1

import kotlinx.coroutines.*

class UserDataManager2 {
    private var count = 0
    private lateinit var deferred: Deferred<Int>
    suspend fun getTotalUserCount(): Int {

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }

            deferred = async(Dispatchers.IO) {
                delay(3000)
                return@async 70
            }

        }
        return count + deferred.await()
    }
}