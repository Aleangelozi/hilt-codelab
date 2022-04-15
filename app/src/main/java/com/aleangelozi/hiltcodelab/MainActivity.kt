package com.aleangelozi.hiltcodelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aleangelozi.hiltcodelab.database.DatabaseAdapter
import com.aleangelozi.hiltcodelab.database.DatabaseService
import com.aleangelozi.hiltcodelab.hilt.CallInterceptor
import com.aleangelozi.hiltcodelab.hilt.ResponseInterceptor
import com.aleangelozi.hiltcodelab.network.NetworkAdapter
import com.aleangelozi.hiltcodelab.network.NetworkService
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "DatabaseAdapter: $databaseAdapter")
        databaseAdapter.log("Hello Hilt")

        //networkAdapter.log("Interface binding")
        networkService.performNetworkCall()
        networkService2.performNetworkCall()
        networkService3.performNetworkCall()
    }

    // Method Injection
    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Method injection")
    }
}