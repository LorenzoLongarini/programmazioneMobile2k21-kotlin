package com.example.easycooking.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easycooking.R

class Ricetta_del_giorno : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.fragment_ricetta_del_giorno, container, false)
        return view
    }

    companion object {
        fun newInstance(): Ricetta_del_giorno {
            return Ricetta_del_giorno()
        }

    }
}