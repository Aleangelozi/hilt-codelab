package com.aleangelozi.hiltcodelab.database

import android.util.Log
import com.aleangelozi.hiltcodelab.TAG
import javax.inject.Inject

// Construction Injection
class DatabaseService @Inject constructor() {
    fun log(message: String) {
        Log.d(TAG, "Database Service Message: $message")
    }

}