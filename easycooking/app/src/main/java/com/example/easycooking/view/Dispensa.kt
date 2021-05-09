package com.example.easycooking.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.dispensa.MyAdapter
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class Dispensa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispensa)

        val rv: RecyclerView =findViewById(R.id.rv)
        rv.layoutManager= LinearLayoutManager(this)
        rv.addItemDecoration(
            DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.provider_name_horizontal_margin),
            resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin))
        )


        val alphaAdapter = AlphaInAnimationAdapter(MyAdapter(TODO("PASSARE LA LISTA DELLA DISPENSA"))).apply {
            // Change the durations.
            setDuration(750)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }
        rv.adapter = ScaleInAnimationAdapter(alphaAdapter).apply {
            // Change the durations.
            setDuration(350)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }
    }

}