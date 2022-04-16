package com.aleangelozi.hiltcodelab.stats

import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor() : ViewModel() {

    val statsLiveData = MutableLiveData<Int>()
    var i = 0
    var runnable: Runnable? = null

    fun statsStatsCollection() {
        val h = android.os.Handler(Looper.getMainLooper())
        runnable = Runnable {
            statsLiveData.value = ++i
            h.postDelayed(runnable!!, 500)
        }
        h.postDelayed(runnable!!, 500)
    }
}