package com.example.easycooking.ViewModels

import android.os.Handler
import androidx.lifecycle.ViewModel
import com.example.easycooking.adapter.ricetta.Ricetta
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ricettaDelGiornoViewModel : ViewModel(){
    private lateinit var dbref: DatabaseReference
    //private var ricettaArray1:ArrayList<Ricetta> = getRicette()
    private val ricetta: Ricetta by lazy {
        Ricetta().also {

        }
    }


    /*private fun randomizeRecipe() : Ricetta{
        val h = Handler()
        var ricettina:Ricetta
        h.postDelayed(object : Runnable {
            override fun run() {
                ricettina = ricettaArray1.random()
                h.postDelayed(this, 86400)
            }

        }, 0) // 1 second delay (takes millis)
        return ricettina
    }

    fun getRicette() : ArrayList<Ricetta> {
        val ricettaArray = arrayListOf<Ricetta>()
        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.get().addOnSuccessListener {
            for (ricetteSnapshot in it.children) {
                val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                ricettaArray.add(ricetta!!)
            }
        }
        return ricettaArray
    }*/
    }






