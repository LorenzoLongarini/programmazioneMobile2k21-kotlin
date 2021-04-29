package com.example.easycooking.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.network.RicetteModel

class RicetteAdapter (private val mRicette:List<RicetteModel>) :RecyclerView.Adapter<RicetteAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {

        val nomeTextView = itemView.findViewById<TextView>(R.id.ricetta_nome)
        val gobutton = itemView.findViewById<TextView>(R.id.bottone_go)
        val foto_ricetta = itemView.findViewById<ImageView>(R.id.foto_ricetta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicetteAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val ricettaView = inflater.inflate(R.layout.item_ricetta, parent, false)
        // Return a new holder instance
        return ViewHolder(ricettaView)
    }

    override fun onBindViewHolder(viewHolder: RicetteAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val ricetta: RicetteModel = mRicette.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nomeTextView
        textView.setText(ricetta.nome)
        val imageView = viewHolder.foto_ricetta
        imageView.setImageDrawable(ricetta.img)
        val button = viewHolder.gobutton

    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mRicette.size
    }
}
