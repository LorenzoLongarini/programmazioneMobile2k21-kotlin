package com.example.easycooking.adapter.dispensa

class Dispensa(s: String, i: Int, u:String) {
    var Nome:String=s
    var Quant:Int=i
    var unita:String=u


    fun agg_disp(nuovo: Dispensa, listDispensa:Array<Dispensa>){
        for (el in listDispensa) {
            if (nuovo.Nome.equals(el.Nome))
                el.Quant = el.Quant + nuovo.Quant
        }
        listDispensa.plus(nuovo)
    }
}