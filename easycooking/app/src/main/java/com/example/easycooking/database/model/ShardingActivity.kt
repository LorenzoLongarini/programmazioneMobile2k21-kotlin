package com.example.easycooking.database.model

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ShardingActivity : AppCompatActivity() {

    private fun getMultipleInstances() {
        // [START rtdb_multi_instance]
        // Get the default database instance for an app
        val primary = Firebase.database.reference

        // Get a secondary database instance by URL
        val secondary = Firebase.database("https://gino-49a3d-default-rtdb.firebaseio.com").reference
        // [END rtdb_multi_instance]
    }
}
