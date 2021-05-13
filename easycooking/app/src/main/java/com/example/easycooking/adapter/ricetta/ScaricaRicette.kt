package com.example.easycooking.adapter.ricetta

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class ScaricaRicette {
    var appoggio= mutableListOf<Ricetta>()

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val docRef = db.collection("cook").document("100")
    docRef.get().addOnSuccessListener { documentSnapshot ->
        val ric = documentSnapshot.toObject<Ricetta>()
        if (ric != null) {
            appoggio.add(ric)
        }}
}