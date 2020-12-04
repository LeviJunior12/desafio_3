package com.example.desafio_3.adapter

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_3.R
import com.example.desafio_3.entity.Hqs
import com.example.desafio_3.entity.marvel.ComicsWrapper
import com.example.desafio_3.entity.marvel.Results
import com.squareup.picasso.Picasso

class HqsAdapter(var listHqs: ArrayList<Results>):
    RecyclerView.Adapter<HqsAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_hqs, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var hqs = listHqs.get(position)

        var pathImage = "${hqs.thumbnail.path.replace("http", "https")}.${hqs.thumbnail.extension}"
        var issueNumber = "#${hqs.issueNumber}"

        Picasso.get().load(pathImage).into(holder.cover_image)
        holder.number_hqs.text = issueNumber
    }

    override fun getItemCount() = listHqs.size

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cover_image = itemView.findViewById<ImageView>(R.id.iv_cover_page)
        var number_hqs = itemView.findViewById<TextView>(R.id.tv_number_hqs)
    }
}