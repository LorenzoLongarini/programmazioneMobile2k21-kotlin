package com.example.easycooking.adapter.ricetta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.ricetta.RicettaListAdapter.RicettaViewHolder.Companion.create


import com.example.easycooking.spesa.SpesaDBEntity
import com.example.easycooking.spesa.SpesaListAdapter
import com.example.easycooking.spesa.SpesaListAdapter.SpesaViewHolder.Companion.create

 class RicettaListAdapter : ListAdapter<RicettaDBEntity, RicettaListAdapter.RicettaViewHolder>(RicettaComparator()) {
    var elemo = ArrayList<RicettaDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicettaViewHolder {
        return RicettaViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RicettaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nome)


    }

    class RicettaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ricettaItemView: TextView = itemView.findViewById(R.id.nome_ric)
        //val comprato:Button=itemView.

        fun bind(text: String?) {
            ricettaItemView.text = text

        }

        companion object {
            fun create(parent: ViewGroup): RicettaViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.cards, parent, false)
                return RicettaViewHolder(view)
            }
        }
    }

    class RicettaComparator : DiffUtil.ItemCallback<RicettaDBEntity>() {
        override fun areItemsTheSame(oldItem: RicettaDBEntity, newItem: RicettaDBEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RicettaDBEntity, newItem: RicettaDBEntity): Boolean {
            return oldItem.nome == newItem.nome
        }
    }


 }