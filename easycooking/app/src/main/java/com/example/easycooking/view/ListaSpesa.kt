package com.example.easycooking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.easycooking.R

class ListaSpesa : Fragment(R.layout.fragment_listaspesa) {
    companion object {

        fun newInstance(): ListaSpesa {
            return ListaSpesa()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_listaspesa, container, false)
        return view
    }

}