package com.example.easycooking.memory.spesa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R

/**
 * Questa classe ci permette di visualizzare nella recycler view
 * tutti i prodotti presenti nella lista della spesa
 *
 */

class SpesaListAdapter : ListAdapter<SpesaDBEntity, SpesaListAdapter.SpesaViewHolder>(SpesaComparator()) {
    var elems = ArrayList<SpesaDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpesaViewHolder {
        return SpesaViewHolder.create(parent)
    }

    /**
     * Attraverso questa funzione, viene lanciata la richiesta per visualizzare i prodotti presenti in dispensa
     */
    override fun onBindViewHolder(holder: SpesaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nomeProdotto)


    }

    /**
     * visualizzazione di un prodotto nella recyclerView
     *
     */
    class SpesaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val spesaItemView: TextView = itemView.findViewById(R.id.prodotto_compra)

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

    /**
     * questa classe viene utilizzata per verificare se il prodotto è già presente o meno nella lista della spesa.
     * Nel caso in cui fosse presente, il vecchio prodotto è sostituito dal nuovo
     *
     */
    class SpesaComparator : DiffUtil.ItemCallback<SpesaDBEntity>() {
        override fun areItemsTheSame(oldItem: SpesaDBEntity, newItem: SpesaDBEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SpesaDBEntity, newItem: SpesaDBEntity): Boolean {
            return oldItem.nomeProdotto == newItem.nomeProdotto
        }
    }
}