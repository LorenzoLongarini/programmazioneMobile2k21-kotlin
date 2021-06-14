package com.example.easycooking.memory.spesa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R



class SpesaListAdapter : ListAdapter<SpesaDBEntity, SpesaListAdapter.SpesaViewHolder>(SpesaComparator()) {
    var elems = ArrayList<SpesaDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpesaViewHolder {
        return SpesaViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SpesaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nomeProdotto)


    }

    class SpesaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val spesaItemView: TextView = itemView.findViewById(R.id.prodotto_compra)
        //val comprato:Button=itemView.

        fun bind(text: String?) {
            spesaItemView.text = text

        }

        companion object {
            fun create(parent: ViewGroup): SpesaViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_compra, parent, false)
                return SpesaViewHolder(view)
            }
        }
    }

    class SpesaComparator : DiffUtil.ItemCallback<SpesaDBEntity>() {
        override fun areItemsTheSame(oldItem: SpesaDBEntity, newItem: SpesaDBEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SpesaDBEntity, newItem: SpesaDBEntity): Boolean {
            return oldItem.nomeProdotto == newItem.nomeProdotto
        }
    }
}