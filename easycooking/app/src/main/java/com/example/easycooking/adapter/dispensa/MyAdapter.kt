package com.example.easycooking.adapter.dispensa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.DB.DispensaDBEntity
import com.example.easycooking.R

class MyAdapter(val data: List<DispensaDBEntity>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val textView = row.findViewById<TextView>(R.id.nome)
        val textView2 = row.findViewById<TextView>(R.id.prodotto_quant)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var nome_dis:String?=data.get(position).nomeProdotto
        holder.textView.text = nome_dis
        var qua_dis:Int?=data.get(position).quantProdotto
        var um_dis:String?=data.get(position).unitProdotto
        var puttt:String=(qua_dis.toString())+" "+um_dis
        holder.textView2.text = puttt
    }


    override fun getItemCount(): Int = data.size
}