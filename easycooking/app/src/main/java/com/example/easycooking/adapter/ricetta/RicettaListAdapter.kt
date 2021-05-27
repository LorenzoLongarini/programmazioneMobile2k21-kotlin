package com.example.easycooking.adapter.ricetta


import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easycooking.R

class RicettaListAdapter : ListAdapter<RicettaDBEntity, RicettaListAdapter.RicettaViewHolder>(
     RicettaComparator()
 ) {
    var elemo = ArrayList<RicettaDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicettaViewHolder {
        return RicettaViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RicettaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nome, current.image)


    }

    class RicettaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ricettaItemView: TextView = itemView.findViewById(R.id.nome_ric)
        private val ricettaPhoto:ImageView=itemView.findViewById(R.id.foto_ricetta_cerca)
        //val comprato:Button=itemView.

        fun bind(text: String?,fotoo:String?) {
            ricettaItemView.text = text
            val uri: Uri = Uri.parse(fotoo)
            Glide.with(itemView)
                .load(uri)
                .into(ricettaPhoto)

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