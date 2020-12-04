package com.example.desafio_3.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio_3.entity.Hqs
import com.example.desafio_3.entity.marvel.ComicsWrapper
import com.example.desafio_3.entity.marvel.Data
import com.example.desafio_3.entity.marvel.Results
import com.example.desafio_3.service.Service
import kotlinx.coroutines.launch

class MenuViewModel(val service: Service) : ViewModel() {

    var listResult = MutableLiveData<ArrayList<Results>>()

    fun getListRepo() {
        viewModelScope.launch {
            listResult.value = service.getResults("1009610", "1", "484aabccfdee8f7fb36050a933af2cd6", "803577de0ce5cc73cb0b03144f63779c").data.results
        }
    }


}