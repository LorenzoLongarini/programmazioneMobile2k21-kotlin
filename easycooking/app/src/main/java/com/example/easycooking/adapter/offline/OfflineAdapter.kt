package com.example.easycooking.adapter.offline

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easycooking.R
import com.example.easycooking.view.Activity_ricetta
import android.net.Uri
import androidx.recyclerview.widget.ListAdapter

class OfflineAdapter: ListAdapter<OfflineDBEntity, OfflineAdapter.OfflineViewHolder>
    (OfflineComparator()) {

    var elemo1 = ArrayList<OfflineDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfflineViewHolder {
        return OfflineViewHolder(parent)
    }


    override fun onBindViewHolder(holder: OfflineViewHolder, position: Int) {
        val currentitem = getItem(position)
        holder.bind(currentitem.nome, currentitem.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Activity_ricetta::class.java)
            intent.putExtra("Titolo", currentitem.nome)
            intent.putExtra("Prep", currentitem.prepTime)
            intent.putExtra("Cott", currentitem.cookTime)
            //intent.putExtra("Tot", currentitem.totalTime)
            intent.putExtra("Cat", currentitem.recipeCategory)
            intent.putExtra("Orig", currentitem.recipeCuisine)
            //intent.putExtra("Intoll", currentitem.intolleranze?.toTypedArray())
            //intent.putExtra("Veg", currentitem.vegano)
            intent.putExtra("Ingr", currentitem.Ingredienti)
            //intent.putExtra("Quant", currentitem.quantita?.toTypedArray())
            //intent.putExtra("Unit", currentitem.unita?.toTypedArray())
            intent.putExtra("Preparaz", currentitem.preparazione)
            intent.putExtra("image", currentitem.image)
            holder.itemView.context.startActivity(intent)
        }

    }

    class OfflineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ricettaItemView1: TextView = itemView.findViewById(R.id.nome_ric)
        private val ricettaPhoto1: ImageView = itemView.findViewById(R.id.foto_ricetta_cerca)


        fun bind(text: String?, foto: String?) {
            ricettaItemView1.text = text
            val uri: Uri = Uri.parse(foto)
            Glide.with(itemView)
                .load(uri)
                .into(ricettaPhoto1)

        }

    }

    companion object {
        fun create(parent: ViewGroup): OfflineAdapter.OfflineViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.cards, parent, false)
            return OfflineAdapter.OfflineViewHolder(view)
        }
    }

    class OfflineComparator : DiffUtil.ItemCallback<OfflineDBEntity>() {
        override fun areItemsTheSame(oldItem: OfflineDBEntity, newItem: OfflineDBEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: OfflineDBEntity,
            newItem: OfflineDBEntity
        ): Boolean {
            return oldItem.nome == newItem.nome
        }
    }
}

