package com.example.easycooking.memory.dispensa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R

/**
 *  Questa classe è utilizzata per impostare la recycler view riguardante la dispensa e gli elementi al suo interno
 *
 */

class DispensaListAdapter : ListAdapter<DispensaDBEntity, DispensaListAdapter.DispensaViewHolder>(DispComparator()) {
    var elem = ArrayList<DispensaDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DispensaViewHolder {
        return DispensaViewHolder.create(parent)
    }

    /**
     * Attraverso questa funzione, viene visualizzato ogni ingrediente presente in dispensa
     *
     */
    override fun onBindViewHolder(holder: DispensaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nomeProdotto)

    }

    /**
     * Attraverso questa classe, vengono visualizzati tutti gli ingredienti presenti nella dispensa
     *
     */
    class DispensaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dispensaItemView: TextView = itemView.findViewById(R.id.nome)

        fun bind(text: String?) {
            dispensaItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): DispensaViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_view, parent, false)
                return DispensaViewHolder(view)
            }
        }
    }

    /**
     * questa classe viene utilizzata per verificare se l'ingrediente inserito è gia presente o meno in dispensa.
     * Nel caso in cui fosse presente, il vecchio ingrediente è sostituito dal nuovo, aventi entrambi lo stesso nome
     *
     */
    class DispComparator : DiffUtil.ItemCallback<DispensaDBEntity>() {
            override fun areItemsTheSame(oldItem: DispensaDBEntity, newItem: DispensaDBEntity): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: DispensaDBEntity, newItem: DispensaDBEntity): Boolean {
                return oldItem.nomeProdotto == newItem.nomeProdotto
            }
        }
    }
