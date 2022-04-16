package com.aleangelozi.hiltcodelab

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aleangelozi.hiltcodelab.database.DatabaseAdapter
import com.aleangelozi.hiltcodelab.database.DatabaseService
import com.aleangelozi.hiltcodelab.hilt.ResponseInterceptor
import com.aleangelozi.hiltcodelab.network.NetworkService
import com.aleangelozi.hiltcodelab.stats.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Field Injection
    @Inject lateinit var databaseAdapter: DatabaseAdapter
    //@Inject lateinit var networkAdapter: NetworkAdapter

    //@CallInterceptor
    @ResponseInterceptor
    @Inject lateinit var networkService: NetworkService

    @ResponseInterceptor
    @Inject lateinit var networkService2: NetworkService

    @ResponseInterceptor
    @Inject lateinit var networkService3: NetworkService

    private val statsViewModel by viewModels<StatsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "DatabaseAdapter: $databaseAdapter")
        databaseAdapter.log("Hello Hilt")

        //networkAdapter.log("Interface binding")
        networkService.performNetworkCall()
        networkService2.performNetworkCall()
        networkService3.performNetworkCall()

        statsViewModel.statsStatsCollection()
        statsViewModel.statsLiveData.observe(this) { stats ->
            Log.d(TAG, "New stat coming in: $stats")
        }

    }

    // Method Injection
    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Method injection")
    }
}