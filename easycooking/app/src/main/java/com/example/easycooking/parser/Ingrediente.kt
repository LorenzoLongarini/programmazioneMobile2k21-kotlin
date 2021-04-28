package com.example.easycooking.parser

class Ingrediente {
    var nomeIngr: String? =null
    var quantità:String?=null
    var unitaMisura:String?=null

    constructor(nomeIngr: String?, quantità: String?, unitaMisura: String?){
        this.nomeIngr=nomeIngr
        this.quantità=quantità
        this.unitaMisura=unitaMisura
    }
}