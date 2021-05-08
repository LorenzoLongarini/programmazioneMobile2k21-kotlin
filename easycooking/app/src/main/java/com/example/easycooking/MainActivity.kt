package com.example.easycooking

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.view.RicetteCerca
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    val LOGIN_REQUEST = 101
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val preferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        if (preferences.getBoolean("firstrun", true)) {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivityForResult(intent, LOGIN_REQUEST)
        } else {
            mAuth = FirebaseAuth.getInstance()
            val currentUser = mAuth!!.getCurrentUser()
            supportActionBar!!.setTitle(currentUser.displayName)
        }

        fun senzaReg(v: View) {
            val intent = Intent(this, RicetteCerca::class.java)
            startActivity(intent)
        }
    }
}