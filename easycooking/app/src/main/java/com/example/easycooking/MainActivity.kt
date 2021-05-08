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

    }
    fun senzaReg(v: View) {
        val intent = Intent(this, RicetteCerca::class.java)
        startActivity(intent)
    }

    fun registratiView(v: View) {
        val intent2 = Intent(this, LoginActivity::class.java)
        startActivity(intent2)
    }
}