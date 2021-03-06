package com.example.easycooking.memory.ricettaTua


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.example.easycooking.memory.ricetta.Ricetta
import com.example.easycooking.memory.spesa.ListaSpesaDispensa
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.cards.view.*

/**
 * Questa classe ci permette di visualizzare nella recycler view tutte le ricette
 * filtrate per ingredienti. Cliccando sulla card presente nella recycler view,
 * è poi possibile visualizzare le specifiche nel dettaglio della ricetta.
 *
 */

class RicettaAdapterDispensa(
    val items: ArrayList<Ricetta>,
    val context: Context,
    val ingr: MutableList<String>
) : RecyclerView.Adapter<RicettaAdapterDispensa.RicettaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicettaViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
        return RicettaViewHolder(layout)
    }

    override fun getItemCount(): Int = items.size

    //viene definita e inizializzata un'istanza di Firebase
    val storage = Firebase.storage

    /**
     * Attraverso questa funzione, viene lanciata la richiesta per visualizzare la ricetta fitrata per ingredienti
     * e scaricata da Firebase. Cliccando poi la card, viene visualizzata interamente
     */
    override fun onBindViewHolder(holder: RicettaViewHolder, position: Int) {
        val currentitem = items.get(position)
        holder.nomeRicetta.text = currentitem.nome

        /*
         * viene scaricata l'immagine da Firebase facendo prima un controllo se questa sia o meno presente
         */
        val n_image = "images/".plus(currentitem.image)
        val imagereference = storage.reference.child(n_image)
        imagereference.downloadUrl.addOnSuccessListener { uri ->
            Glide.with(holder.itemView)
                .load(uri)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL) //ALL or NONE as your requirement
                .into(holder.itemView.foto_ricetta_cerca)
        }.addOnFailureListener { // Handle any errors
            //se l'immagine non è presente, viene sostituita con l'immagine di default
            Glide.with(holder.itemView)
                .load(R.drawable.coltforc)
                .fitCenter()
                .into(holder.itemView.foto_ricetta_cerca)
        }

        //vengono aggiornati i campi della ricetta nel momento in cui l'utente clicca sulla card specifica
        holder.itemView.setOnClickListener {
            val intent= Intent(context,ListaSpesaDispensa::class.java)
            intent.putExtra("Titolo", currentitem.nome)
            intent.putExtra("Prep",currentitem.prepTime)
            intent.putExtra("Cott",currentitem.cookTime)
            intent.putExtra("Tot",currentitem.totalTime)
            intent.putExtra("Cat",currentitem.recipeCategory)
            intent.putExtra("Orig",currentitem.recipeCuisine)
            intent.putExtra("Intoll", currentitem.intolleranze?.toTypedArray())
            intent.putExtra("Veg", currentitem.vegano)
            intent.putExtra("Ingr",currentitem.Ingredienti?.toTypedArray())
            intent.putExtra("Quant",currentitem.quantita?.toTypedArray())
            intent.putExtra("Unit",currentitem.unita?.toTypedArray())
            intent.putExtra("Preparaz",currentitem.preparazione)
            intent.putExtra("image",currentitem.image)
            //vengono qui inseriti gli ingredienti
            intent.putExtra("Disp",ingr.toTypedArray())

            //la visualizzazione della ricetta avviene dopo il click sulla singola card della ricetta filtrata
            context.startActivity(intent)
        }

    }

    /**
     * visualizzazione della ricetta nella recyclerView
     *
     */
    inner class RicettaViewHolder(row: View) : RecyclerView.ViewHolder(row) {

       val nomeRicetta = row.findViewById<TextView>(R.id.nome_ric)
    }


}




