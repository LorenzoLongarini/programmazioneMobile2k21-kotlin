package com.example.easycooking.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easycooking.R


class Contattaci : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_contattaci, container, false)
        return view
    }

    companion object {
        fun newInstance(): Contattaci {
            return Contattaci()
            }
    }
}