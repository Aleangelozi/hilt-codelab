package com.aleangelozi.hiltcodelab.network

import android.util.Log
import com.aleangelozi.hiltcodelab.TAG
import javax.inject.Inject

class ResponseInterceptorImpl @Inject constructor(): Interceptor {
    override fun log(message: String) {
        Log.d(TAG, "This is response interceptor: $message")
    }
}