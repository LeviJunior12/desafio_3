package com.example.desafio_3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_3.R
import com.example.desafio_3.adapter.HqsAdapter
import com.example.desafio_3.entity.Hqs
import com.example.desafio_3.entity.marvel.ComicsWrapper
import com.example.desafio_3.entity.marvel.Results
import com.example.desafio_3.service.service
import com.example.desafio_3.viewmodel.MenuViewModel
import kotlinx.android.synthetic.main.fragment_hqs.*
import kotlinx.android.synthetic.main.fragment_hqs.view.*

class HqsFragment : Fragment(), HqsAdapter.onClickLIstenerHq {

    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var hqsAdapter: HqsAdapter

    val viewModel by viewModels<MenuViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MenuViewModel(service) as T // Com parametro
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_hqs, container, false)

        viewModel.listResult.observe(viewLifecycleOwner) {
            hqsAdapter = HqsAdapter(it, this)
            rv_hqs.adapter = hqsAdapter

        }

        var recycleView = view.rv_hqs
        gridLayoutManager = GridLayoutManager(this.context, 3, LinearLayoutManager.VERTICAL, false)

        recycleView.layoutManager = gridLayoutManager
        recycleView.setHasFixedSize(true)

        viewModel.getListRepo()

        return view
    }


    override fun hqClick(position: Int) {
        viewModel.listResult.observe(this, {
            var hq = it.get(position)

            val bundle = bundleOf("hq" to hq)
            findNavController().navigate(R.id.action_hqsFragment_to_detailHqsragment, bundle)
        })
    }

}