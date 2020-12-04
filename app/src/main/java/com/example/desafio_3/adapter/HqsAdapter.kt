package com.example.desafio_3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_3.R
import com.example.desafio_3.entity.marvel.Results
import com.squareup.picasso.Picasso

class HqsAdapter(var listHqs: ArrayList<Results>, val click: onClickLIstenerHq):
    RecyclerView.Adapter<HqsAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_hqs, parent, false)
        return ItemHolder(itemHolder, listHqs)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var hqs = listHqs.get(position)

        var pathImage = "${hqs.thumbnail.path.replace("http", "https")}.${hqs.thumbnail.extension}"
        var issueNumber = "#${hqs.issueNumber}"

        Picasso.get().load(pathImage).into(holder.cover_image)
        holder.number_hqs.text = issueNumber

        holder.itemView.setOnClickListener {
            click.hqClick(position)
        }
    }

    interface onClickLIstenerHq {
        fun hqClick(position: Int)
    }

    override fun getItemCount() = listHqs.size

    class ItemHolder(itemView: View, listHqs: ArrayList<Results>): RecyclerView.ViewHolder(itemView) {
        var cover_image = itemView.findViewById<ImageView>(R.id.iv_cover_page)
        var number_hqs = itemView.findViewById<TextView>(R.id.tv_number_hqs)
    }
}