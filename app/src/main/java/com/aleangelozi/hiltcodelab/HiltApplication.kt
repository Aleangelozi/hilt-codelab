package com.aleangelozi.hiltcodelab

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

const val TAG = "HiltLogTag"

@HiltAndroidApp
class HiltApplication : Application() {
}