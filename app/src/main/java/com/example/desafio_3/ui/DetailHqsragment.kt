package com.example.desafio_3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.desafio_3.R
import com.example.desafio_3.entity.marvel.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_hqsragment.*
import kotlinx.android.synthetic.main.fragment_detail_hqsragment.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class DetailHqsragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_hqsragment, container, false)

        var detalheHqs = arguments?.get("hq") as Results
        var pathImage = "${detalheHqs.thumbnail.path.replace("http", "https")}.${detalheHqs.thumbnail.extension}"
        var published = "Published: ${detalheHqs.dates[0].date}"
        var price = "Price: ${detalheHqs.prices[0].price.toString()}"
        var totalPage = "Pages: ${detalheHqs.pageCount}"

        if(detalheHqs.description == null) {
            view.tv_describe.text = "Não há descrição!"
        } else {
            view.tv_describe.text = detalheHqs.description
        }

        Picasso.get().load(pathImage).into(view.iv_main)
        Picasso.get().load(pathImage).into(view.iv_comic)
        view.tv_title.text = detalheHqs.title
        view.tv_published.text = published
        view.tv_price.text = price
        view.tv_pages.text = totalPage

        view.toolbar_icon.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_detailHqsragment_to_hqsFragment)
        }

        return view
    }

}