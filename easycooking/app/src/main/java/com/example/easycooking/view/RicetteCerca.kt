package com.example.easycooking.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.LoginActivity
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.dispensa.Dispensa
import com.google.firebase.auth.FirebaseAuth


class RicetteCerca : Fragment(R.layout.fragment_ricettecerca) {
    companion object {

        fun newInstance(): RicetteCerca {
            return RicetteCerca()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_ricettecerca, container, false)
        return view
    }
}
