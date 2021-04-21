package com.example.easycooking

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.adapters.RicetteAdapter
import com.example.easycooking.models.RicetteModel

class RicetteListActivity : AppCompatActivity() {
    lateinit var ricette: ArrayList<RicetteModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...
        // Lookup the recyclerview in activity layout
        val rvRicette = findViewById<View>(R.id.rvRicette) as RecyclerView
        // Initialize contacts
        ricette = RicetteModel.creaListaRicette()
        // Create adapter passing in the sample user data
        val adapter = RicetteAdapter(ricette)
        // Attach the adapter to the recyclerview to populate items
        rvRicette.adapter = adapter
        // Set layout manager to position the items
        rvRicette.layoutManager = LinearLayoutManager(this)
        // That's all!
    }
}