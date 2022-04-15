package com.aleangelozi.hiltcodelab.network

import android.util.Log
import com.aleangelozi.hiltcodelab.TAG
import javax.inject.Inject

class MyAppNetworkAdapter @Inject constructor(): NetworkAdapter {
    override fun log(message: String) {
        Log.d(TAG, "MyNetworkAdapter: $message")
    }
}