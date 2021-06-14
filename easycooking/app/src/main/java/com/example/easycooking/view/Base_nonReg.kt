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

/**
 * Activity base per gli utenti non registrati
 */


class Base_nonReg : AppCompatActivity() {

    lateinit var app_bar: AppBarConfiguration
    lateinit var  navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_non_reg)

        //navigation bottom
        val bottone = findViewById<BottomNavigationView>(R.id.navigation_bottom)
        navController = findNavController(R.id.fragment2)
        bottone.setupWithNavController(navController)

        //appbar
        app_bar = AppBarConfiguration(navController.graph, drawerlayout)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerlayout)
        NavigationUI.setupWithNavController(navigation_view,navController)

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
        menuInflater.inflate(R.menu.option_menu_nonreg, menu)
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