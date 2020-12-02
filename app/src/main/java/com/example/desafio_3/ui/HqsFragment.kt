package com.example.desafio_3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_3.R
import com.example.desafio_3.adapter.HqsAdapter
import com.example.desafio_3.entity.Hqs
import kotlinx.android.synthetic.main.fragment_hqs.*

class HqsFragment : Fragment() {

    lateinit var recycleView: RecyclerView
    lateinit var gridLayoutManager: GridLayoutManager
    var listHqs = setDataInList()
    lateinit var hqsAdapter: HqsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_hqs, container, false)

        recycleView = view.findViewById(R.id.rv_hqs)
        gridLayoutManager = GridLayoutManager(this.context, 3, LinearLayoutManager.VERTICAL, false)
        recycleView.layoutManager = gridLayoutManager
        recycleView.setHasFixedSize(true)
        hqsAdapter = HqsAdapter(listHqs)
        recycleView.adapter = hqsAdapter

        return view
    }

    companion object {
        fun newInstance() = HqsFragment()
    }

    private fun setDataInList(): ArrayList<Hqs> {
        var items: ArrayList<Hqs> = ArrayList()

        items.add(Hqs(1, R.drawable.marvel_logo))
        items.add(Hqs(2, R.drawable.marvel_logo))
        items.add(Hqs(3, R.drawable.marvel_logo))
        items.add(Hqs(4, R.drawable.marvel_logo))
        items.add(Hqs(5, R.drawable.marvel_logo))
        items.add(Hqs(6, R.drawable.marvel_logo))
        items.add(Hqs(7, R.drawable.marvel_logo))
        items.add(Hqs(8, R.drawable.marvel_logo))
        items.add(Hqs(9, R.drawable.marvel_logo))
        items.add(Hqs(10, R.drawable.marvel_logo))
        items.add(Hqs(11, R.drawable.marvel_logo))
        items.add(Hqs(12, R.drawable.marvel_logo))
        items.add(Hqs(13, R.drawable.marvel_logo))
        items.add(Hqs(14, R.drawable.marvel_logo))
        items.add(Hqs(15, R.drawable.marvel_logo))
        items.add(Hqs(16, R.drawable.marvel_logo))
        items.add(Hqs(17, R.drawable.marvel_logo))
        items.add(Hqs(18, R.drawable.marvel_logo))
        items.add(Hqs(19, R.drawable.marvel_logo))
        items.add(Hqs(20, R.drawable.marvel_logo))

        return items
    }
}