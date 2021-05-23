package com.example.easycooking.adapter.dispensa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.DB.DispensaDBEntity
import com.example.easycooking.R

class DispensaListAdapter : ListAdapter<DispensaDBEntity, DispensaListAdapter.DispensaViewHolder>(DispComparator()) {
    var elem = ArrayList<DispensaDBEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DispensaViewHolder {
        return DispensaViewHolder.create(parent)
    }

    /*fun del(position: Int){
        elem.removeAt(position)
        notifyDataSetChanged()
    }*/

    override fun onBindViewHolder(holder: DispensaViewHolder, position: Int) {
        val current = getItem(position)
        //holder.bind(current.nomeProdotto,current.quantProdotto,current.unitProdotto)
        holder.bind(current.nomeProdotto)

    }

    /*fun del(position: Int){
        elem.removeAt(position)
        notifyDataSetChanged()

    }*/



    class DispensaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dispensaItemView: TextView = itemView.findViewById(R.id.nome)
       // private val dispensaQuant:TextView=itemView.findViewById(R.id.prodotto_quant)

        /*fun bind(text: String?,i:Int?,text1:String?) {
            //dispensaItemView.text = text
            //dispensaQuant.text=i.toString()+" "+text1
        }*/
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

    class DispComparator : DiffUtil.ItemCallback<DispensaDBEntity>() {
            override fun areItemsTheSame(oldItem: DispensaDBEntity, newItem: DispensaDBEntity): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: DispensaDBEntity, newItem: DispensaDBEntity): Boolean {
                return oldItem.nomeProdotto == newItem.nomeProdotto
            }
        }
    }
