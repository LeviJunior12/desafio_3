package com.example.desafio_3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_3.R
import com.example.desafio_3.entity.Hqs

class HqsAdapter(var listHqs: ArrayList<Hqs>):
    RecyclerView.Adapter<HqsAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_hqs, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var hqs = listHqs.get(position)

        holder.cover_image.setImageResource(hqs.image)
        holder.number_hqs.text = hqs.id.toString()
    }

    override fun getItemCount() = listHqs.size

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cover_image = itemView.findViewById<ImageView>(R.id.iv_cover_page)
        var number_hqs = itemView.findViewById<TextView>(R.id.tv_number_hqs)
    }
}