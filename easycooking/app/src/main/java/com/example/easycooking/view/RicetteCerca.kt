package com.example.easycooking.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.LoginActivity
import com.example.easycooking.R
import com.google.firebase.auth.FirebaseAuth


class RicetteCerca : AppCompatActivity() {
    val LOGIN_REQUEST = 101
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ricettecerca)

    }

    fun login(v: View) {
        val preferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        if (preferences.getBoolean("firstrun", true)) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, LOGIN_REQUEST)
        } else {
            mAuth = FirebaseAuth.getInstance()
            val currentUser = mAuth!!.getCurrentUser()
            supportActionBar!!.setTitle(currentUser.displayName)
        }
    }

    fun dispensa(v: View) {
        val intent = Intent(this, Dispensa::class.java)
        startActivity(intent)
    }

    fun listaSpesa(v: View) {
        val intent = Intent(this, ListaSpesa::class.java)
        startActivity(intent)
    }

    fun ricetteTue(v: View) {
        val intent = Intent(this, RicetteTue::class.java)
        startActivity(intent)
    }

    fun ricetteCerca(v: View) {
        val intent = Intent(this, RicetteCerca::class.java)
        startActivity(intent)
    }
    /* override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == LOGIN_REQUEST) {
            if (resultCode == RESULT_OK) {
                val nome = intent?.extras!!.getString("nome")
                val cognome = intent.extras!!.getString("cognome")
                supportActionBar!!.title = "$nome $cognome"
                val preferences = getSharedPreferences("login", MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putBoolean("firstrun", false)
                editor.apply()
            }
        }*/
}
