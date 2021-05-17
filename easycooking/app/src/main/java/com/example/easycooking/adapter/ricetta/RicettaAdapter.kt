package com.example.easycooking.adapter.ricetta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.MyAdapter

class RicettaAdapter (val data : ArrayList<Ricetta>) : RecyclerView.Adapter<RicettaAdapter.RicettaViewHolder>() {


        class RicettaViewHolder(val row: View) : RecyclerView.ViewHolder(row) {

            //val ingredienti = row.findViewById<TextView>(R.id.ingr)
            //val id = row.findViewById<TextView>(R.id.id)
            //val cookTime = row.findViewById<TextView>(R.id.cook_time)
            //val prepTime = row.findViewById<TextView>(R.id.prep_time)
            //val totalTime = row.findViewById<TextView>(R.id.total_time)
            //val Immagine = row.findViewById<TextView>(R.id.immagine)
           // val intolleranze = row.findViewById<TextView>(R.id.intolleranze)
            //val keywords = row.findViewById<TextView>(R.id.keywords)
            //val porzione = row.findViewById<TextView>(R.id.porzioni)
            //val quantità = row.findViewById<TextView>(R.id.quant)
            //val misura = row.findViewById<TextView>(R.id.misura)
            //val vegano = row.findViewById<TextView>(R.id.vegano)
            //val preparazione = row.findViewById<TextView>(R.id.prep)
           // val categoria = row.findViewById<TextView>(R.id.categoria)
            //val paese = row.findViewById<TextView>(R.id.country)
            //val descrizione = row.findViewById<TextView>(R.id.descr)
            val nomeRicetta = row.findViewById<TextView>(R.id.nome_ric)
            //val textView2 = row.findViewById<TextView>(R.id.prodotto_quant)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicettaViewHolder {
            val layout = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
            return RicettaViewHolder(layout)
        }

        override fun onBindViewHolder(holder: RicettaViewHolder, position: Int) {
            val currentitem = data[position]
            holder.nomeRicetta.text = currentitem.nome
            //holder.ingredienti.text = currentitem.toString()
            //holder.id.text = currentitem.id
           // holder.cookTime.text = currentitem.cookTime
            //holder.prepTime.text = currentitem.prepTime
            //holder.totalTime.text = currentitem.totalTime
           // holder.Immagine.text = currentitem.image
            //holder.intolleranze.text = currentitem.intolleranze
            //holder.keywords.text = currentitem.keywords
            //holder.porzione.text = currentitem.porzioni
            //holder.quantità. = currentitem.quantita
            //holder.misura.text = currentitem.unita
            //holder.vegano.text = currentitem.vegano
            //holder.preparazione.text = currentitem.preparazione
            //holder.categoria.text = currentitem.recipeCategory
           // holder.paese.text = currentitem.recipeCuisine
            //holder.descrizione.text = currentitem.descrizione
            //var puttt:String=(qua_dis.toString())+" "+um_dis
            //holder.textView2.text = puttt
        }

        override fun getItemCount(): Int = data.size
    }
