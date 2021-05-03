package com.example.easycooking.database.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Ingrediente(var nomeIngr:String?=null, var quantità:String?=null, var unitaMisura:String?=null) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
                "nomeIngr" to nomeIngr,
                "quantità" to quantità,
                "unitaMisura" to unitaMisura
        )
    }
}