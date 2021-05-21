package com.example.easycooking.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.ricetta.Ricetta
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import com.google.firebase.database.*
import java.util.ArrayList

class Ricetta_del_giorno : Fragment() {
    private lateinit var dbref: DatabaseReference
    private lateinit var ricettaArray: ArrayList<Ricetta>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.fragment_ricetta_del_giorno, container, false)
        return view
        val nome=view?.findViewById<TextView>(R.id.cardss_nome)
        nome.text=ricettadelGiorno().nome
    }

    companion object {
        fun newInstance(): Ricetta_del_giorno {
            return Ricetta_del_giorno()

        }

    }
    fun ricettadelGiorno():Ricetta{
        var ricettarray=getRicette()
       var ricDay= ricettarray.random()
        return ricDay
    }
    fun getRicette():ArrayList<Ricetta> {
        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (ricetteSnapshot in snapshot.children) {
                        val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                        ricettaArray.add(ricetta!!)
                    }

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        return ricettaArray
    }
}