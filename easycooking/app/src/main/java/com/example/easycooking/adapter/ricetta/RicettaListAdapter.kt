package com.example.easycooking.adapter.ricetta


import android.content.Intent
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
import com.example.easycooking.view.Activity_ricetta
import com.example.easycooking.view.Activity_ricettaTua

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

        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context, Activity_ricettaTua::class.java)
            intent.putExtra("Titolo", current.nome)
            intent.putExtra("Prep",current.prepTime)
            intent.putExtra("Cott",current.cookTime)
            intent.putExtra("Tot",current.totalTime)
            intent.putExtra("Ingr",current.Ingredienti)
            intent.putExtra("Preparaz",current.preparazione)
            holder.itemView.context.startActivity(intent)
        }

    }

    class RicettaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ricettaItemView: TextView = itemView.findViewById(R.id.nome_ric)
        private val ricettaPhoto:ImageView=itemView.findViewById(R.id.foto_ricetta_cerca)
        //val comprato:Button=itemView.


        fun bind(text: String?,foto:String?) {
            ricettaItemView.text = text
            val uri: Uri = Uri.parse(foto)
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