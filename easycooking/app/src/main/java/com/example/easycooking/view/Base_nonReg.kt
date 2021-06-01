package com.example.easycooking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.easycooking.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_base.*

class Base_nonReg : AppCompatActivity() {

    lateinit var app_bar: AppBarConfiguration
    lateinit var  navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_non_reg)
        val bottone = findViewById<BottomNavigationView>(R.id.navigation_bottom)
        navController = findNavController(R.id.fragment2)
        bottone.setupWithNavController(navController)

        app_bar = AppBarConfiguration(navController.graph, drawerlayout)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerlayout)

        NavigationUI.setupWithNavController(navigation_view,navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerlayout)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(drawerlayout)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu_nonreg, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)

    }
}