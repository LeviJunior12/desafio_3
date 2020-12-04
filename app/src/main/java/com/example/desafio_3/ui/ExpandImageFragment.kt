package com.example.desafio_3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.desafio_3.R
import com.example.desafio_3.entity.marvel.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_hqsragment.view.*
import kotlinx.android.synthetic.main.fragment_expand_image.view.*
import kotlinx.android.synthetic.main.fragment_expand_image.view.toolbar_icon

class ExpandImageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_expand_image, container, false)

        var resultHq = arguments?.get("hq") as Results
        var pathImage = "${resultHq.thumbnail.path.replace("http", "https")}.${resultHq.thumbnail.extension}"

        Picasso.get().load(pathImage).into(view.iv_cover)

        view.toolbar_icon.setNavigationOnClickListener {
            val bundle = bundleOf("hq" to resultHq)
            findNavController().navigate(R.id.action_expandImageFragment_to_detailHqsragment, bundle)
        }

        return view
    }
}