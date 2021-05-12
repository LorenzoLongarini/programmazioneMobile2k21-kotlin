package com.example.easycooking.adapter.ricetta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R

class RicettaAdapter (val data: List<Ricetta>) : RecyclerView.Adapter<RicettaAdapter.RicettaViewHolder>() {


        class RicettaViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
            val nomeRicetta = row.findViewById<TextView>(R.id.nome_ricetta)
            //val textView2 = row.findViewById<TextView>(R.id.prodotto_quant)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicettaViewHolder {
            val layout = LayoutInflater.from(parent.context).inflate(R.layout.ricetta_view, parent, false)
            return RicettaViewHolder(layout)
        }

        override fun onBindViewHolder(holder: RicettaViewHolder, position: Int) {
            var nome_ric:String?=data.get(position).getRicettaNome()
            holder.nomeRicetta.text = nome_ric
            //var puttt:String=(qua_dis.toString())+" "+um_dis
            //holder.textView2.text = puttt
        }

        override fun getItemCount(): Int = data.size
    }
