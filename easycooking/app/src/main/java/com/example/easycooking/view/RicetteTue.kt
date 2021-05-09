package com.example.easycooking.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class RicetteTue : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ricettetue)

        val rv: RecyclerView =findViewById(R.id.rv)
        rv.layoutManager= GridLayoutManager(this,2)
        rv.addItemDecoration(
            DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.provider_name_horizontalBig_margin),
                resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin))
        )

        val alphaAdapter = AlphaInAnimationAdapter(RicettaAdapter(TODO("PASSARE LISTA RICETTE"))).apply {
            // Change the durations.
            setDuration(500)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }
        rv.adapter = ScaleInAnimationAdapter(alphaAdapter).apply {
            setDuration(250)
        }

    }

}