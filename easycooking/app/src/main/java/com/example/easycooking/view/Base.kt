package com.example.easycooking.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.easycooking.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenu
import kotlinx.android.synthetic.main.activity_base.*

/**
 * Activity base per gli utenti registrati
 */

class Base : AppCompatActivity() {


    lateinit var app_bar: AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)


        //navigation bottom
        val bottone = findViewById<BottomNavigationView>(R.id.navigation_bottom)
        navController = findNavController(R.id.fragment)
        bottone.setupWithNavController(navController)


        //appbar
        app_bar = AppBarConfiguration(navController.graph, drawerlayout)
        setupActionBarWithNavController(this, navController, drawerlayout)
        NavigationUI.setupWithNavController(navigation_view, navController)


    }

    /**
     * questa funzione viene chiamata ogni volta che
     * l'utente clicca sul navigation menu per accedere
     * alle diverse funzionalità
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(drawerlayout)
    }

    /**
     * Viene visualizzato il menu con tutte le opzioni
     * che possono essere cliccate al suo interno
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    /**
     * Nel momento in cui l'utente clicca su un elemento del navigation menu,
     * viene riportato sul fragment relativo allìelemento selezionato
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}


