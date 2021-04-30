package com.example.easycooking.database

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class ricetteDB {
    fun basicRead(){
        val database=Firebase.database
        val myDB=database.getReference()

        myDB.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot){
                //Questo metodo viene richiamato quando si verifica un aggiornamento
                //di un 'valore' del database
                val value=dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                //Se fallisce nel leggere il valore
                Log.w(TAG, "Non sono riuscito a leggere la ricetta.",error.toException())
            }
        })
    }

    companion object {
        private const val TAG = "KotlinActivity"
    }
}