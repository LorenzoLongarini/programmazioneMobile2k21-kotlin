package com.example.easycooking.adapter.ricetta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easycooking.R


class SingolaRicetta : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_singola_ricetta, container, false)
    }

    companion object {
        fun newInstance(nome: Any): SingolaRicetta {
            return SingolaRicetta()

        }

    }
}