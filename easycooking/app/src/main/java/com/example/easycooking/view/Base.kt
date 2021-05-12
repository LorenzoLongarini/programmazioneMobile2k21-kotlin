package com.example.easycooking.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.easycooking.LoginActivity
import com.example.easycooking.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class Base : AppCompatActivity() {
//    private val LOGIN_REQUEST = 101
//    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        val bottone = findViewById<BottomNavigationView>(R.id.navigation_bottom)
        val navController = findNavController(R.id.fragment)

        bottone.setupWithNavController(navController)

        /*val rv: RecyclerView =findViewById(R.id.rv)
        rv.layoutManager= GridLayoutManager(this,2)
        rv.addItemDecoration(
            DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.provider_name_horizontalBig_margin),
                resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin))
        )*/

        /*val alphaAdapter = AlphaInAnimationAdapter(RicettaAdapter(TODO("PASSARE LISTA RICETTE"))).apply {
            // Change the durations.
            setDuration(500)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }
        rv.adapter = ScaleInAnimationAdapter(alphaAdapter).apply {
            setDuration(250)
        }*/

    }


   /* fun login(v: View) {
        val preferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        if (preferences.getBoolean("firstrun", true)) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, LOGIN_REQUEST)
        } else {
            mAuth = FirebaseAuth.getInstance()
            val currentUser = mAuth!!.getCurrentUser()
            supportActionBar!!.setTitle(currentUser.displayName)
        }
    }*/



    }
