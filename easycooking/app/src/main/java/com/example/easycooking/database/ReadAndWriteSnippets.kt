package com.example.easycooking.database

import android.util.Log
import com.example.easycooking.database.model.Ingrediente
import com.example.easycooking.database.model.Ricetta
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.MutableData
import com.google.firebase.database.Transaction
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ServerValue
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.HashMap

abstract class ReadAndWriteSnippets {

    private val TAG = "ReadAndWriteSnippets"

    // [START declare_database_ref]
    private lateinit var database: DatabaseReference
    // [END declare_database_ref]

    fun initializeDbRef() {
        // [START initialize_database_ref]
        database = Firebase.database.reference
        // [END initialize_database_ref]
    }



    private fun addPostEventListener(postReference: DatabaseReference) {
        // [START post_value_event_listener]
        val ricettaListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val ricetta = dataSnapshot.getValue<Ricetta>()
                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        postReference.addValueEventListener(ricettaListener)
        // [END post_value_event_listener]
    }

    // [START write_fan_out]
    private fun writeNewRicetta(Id: String, nome: String, image: String, descrizione: String, prepTime:String,
                                cookTime:String, totalTime:String, keywords:List<String>, recipeCategory:String, recipeCuisine:String,
                                intolleranze:List<String>, vegano:Boolean, porzioni:String, Ingredienti:List<Ingrediente>, preparazione:String) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        val key = database.child("ricette").push().key
        if (key == null) {
            Log.w(TAG, "Couldn't get push key for posts")
            return
        }

        val ricetta = Ricetta(Id, nome, image, descrizione, prepTime,
                cookTime, totalTime, keywords, recipeCategory, recipeCuisine,
        intolleranze, vegano, porzioni, Ingredienti, preparazione)
        val ricettaValues = ricetta.toMap()

        val childUpdates = hashMapOf<String, Any>(
                "/ricette/$key" to ricettaValues,
        )

        database.updateChildren(childUpdates)
    }
    // [END write_fan_out]


}