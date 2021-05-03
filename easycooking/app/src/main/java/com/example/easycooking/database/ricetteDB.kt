package com.example.easycooking.database

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


abstract class ricetteDB:AppCompatActivity() {

    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Reuse the layout used in MainActivity
        setContentView(R.layout.activity_db)
    }

    fun basicRead(){
        val database=Firebase.database
        val myDB=database.getReference("ricetta")

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


}