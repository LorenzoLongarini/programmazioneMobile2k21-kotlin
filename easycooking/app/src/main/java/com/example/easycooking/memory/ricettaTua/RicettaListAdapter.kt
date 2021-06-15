package com.example.easycooking.memory.ricettaTua


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
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
import com.example.easycooking.memory.ricettaTua.RicettaDBEntity


/**
 * Questa classe ci permette di visualizzare nella recycler view tutte le ricette
 * Cliccando sulla card presente nella recycler view,
 * è poi possibile visualizzare le specifiche nel dettaglio della ricetta.
 *
 */

class RicettaListAdapter : ListAdapter<RicettaDBEntity, RicettaListAdapter.RicettaViewHolder>(
     RicettaComparator()
 ) {
    var elemo = ArrayList<RicettaDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicettaViewHolder {
        return RicettaViewHolder.create(parent)
    }

    /**
     * Attraverso questa funzione, viene lanciata la richiesta per visualizzare la ricette
     * scaricate da Firebase. Cliccando poi su una ricetta specifica, questa viene visualizzata interamente
     */
    override fun onBindViewHolder(holder: RicettaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nome, current.image, current.aiuto)

        //vengono aggiornati i campi della ricetta nel momento in cui l'utente clicca sulla card specifica
        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context, Activity_ricettaTua::class.java)
            intent.putExtra("Titolo", current.nome)
            intent.putExtra("Prep",current.prepTime)
            intent.putExtra("Cott",current.cookTime)
            intent.putExtra("Tot",current.totalTime)
            intent.putExtra("Ingr",current.Ingredienti)
            intent.putExtra("Preparaz",current.preparazione)
            intent.putExtra("aiuto", current.aiuto)
            intent.putExtra("foto",current.image)

            //la visualizzazione della ricetta avviene dopo il click sulla singola card della ricetta filtrata
            holder.itemView.context.startActivity(intent)
        }

    }

    /**
     * viasualizzazione della ricetta nella recyclerView
     *
     */
    class RicettaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ricettaItemView: TextView = itemView.findViewById(R.id.nome_ric)
        private val ricettaPhoto:ImageView=itemView.findViewById(R.id.foto_ricetta_cerca)


        fun bind(text: String?,foto:String?,aiuto:Int) {
            ricettaItemView.text = text
            if(aiuto==1){
            val uri: Uri = Uri.parse(foto)
            Glide.with(itemView)
                .load(uri)
                .into(ricettaPhoto)}
            else if (aiuto==0){
                ricettaPhoto.setImageBitmap(foto?.let { base64ToBitmap(it) })
            } else if (aiuto==2){
                ricettaPhoto.setImageResource(R.drawable.ricvuota)
            }

        }


        companion object {
            fun create(parent: ViewGroup): RicettaViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.cards, parent, false)
                return RicettaViewHolder(view)
            }
        }
    }

    /**
     * questa classe viene utilizzata per verificare se la ricetta è gia presente o meno.
     * Nel caso in cui fosse presente, la vecchia ricetta è sostituita dalla nuova, aventi entrambe lo stesso nome
     *
     */
    class RicettaComparator : DiffUtil.ItemCallback<RicettaDBEntity>() {
        override fun areItemsTheSame(oldItem: RicettaDBEntity, newItem: RicettaDBEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RicettaDBEntity, newItem: RicettaDBEntity): Boolean {
            return oldItem.nome == newItem.nome
        }
    }


 }

/**
 * Questa funzione converte l'immagine da bitmap in una stringa,
 * così che possa essere visualizzata nella singola card
 *
 */
private fun base64ToBitmap(b64: String): Bitmap {
    val imageAsBytes = Base64.decode(b64.toByteArray(), Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
}