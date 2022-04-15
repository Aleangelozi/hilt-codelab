package com.aleangelozi.hiltcodelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aleangelozi.hiltcodelab.database.DatabaseAdapter
import com.aleangelozi.hiltcodelab.database.DatabaseService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Field Injection
    @Inject lateinit var databaseAdapter: DatabaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "DatabaseAdapter: $databaseAdapter")
        databaseAdapter.log("Hello Hilt")
    }

    // Method Injection
    @Inject
    fun directToDatabase(databaseService: DatabaseService) {
        databaseService.log("Method injection")
    }
}