package com.example.easycooking.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.easycooking.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_base.*

class Base : AppCompatActivity() {
//    private val LOGIN_REQUEST = 101
//    private var mAuth: FirebaseAuth? = null
    lateinit var app_bar:AppBarConfiguration
    lateinit var  navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val binding = DataBindingUtil.setContentView<ActivityBaseBinding>(this, R.layout.activity_main)
        setContentView(R.layout.activity_base)

        //navigation bottom
        val bottone = findViewById<BottomNavigationView>(R.id.navigation_bottom)
        navController = findNavController(R.id.fragment)
        bottone.setupWithNavController(navController)

        //appbar
        app_bar = AppBarConfiguration(navController.graph, drawerlayout)
        setupActionBarWithNavController(this, navController, drawerlayout)

        //actionbar
        //drawerlayout = binding.drawerlayout
        //NavigationUI.setupActionBarWithNavController(this, navController, drawerlayout)


        //navigation drawer
        //  findViewById<NavigationView>(R.id.navigation_view).setupWithNavController(navController)


        NavigationUI.setupWithNavController(navigation_view,navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerlayout)
        //NavigationUI.setupWithNavController(navigation_view, navController)
    }
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
        override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp(drawerlayout)
        }
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

