package com.example.easycooking.adapter.dispensa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.DB.DispensaDBEntity
import com.example.easycooking.R

class DispensaListAdapter : ListAdapter<DispensaDBEntity, DispensaListAdapter.DispensaViewHolder>(DISP_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DispensaViewHolder {
        return DispensaViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: DispensaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nomeProdotto)
    }

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

    companion object {
        private val DISP_COMPARATOR = object : DiffUtil.ItemCallback<DispensaDBEntity>() {
            override fun areItemsTheSame(oldItem: DispensaDBEntity, newItem: DispensaDBEntity): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: DispensaDBEntity, newItem: DispensaDBEntity): Boolean {
                return oldItem.nomeProdotto == newItem.nomeProdotto
            }
        }
    }
}
