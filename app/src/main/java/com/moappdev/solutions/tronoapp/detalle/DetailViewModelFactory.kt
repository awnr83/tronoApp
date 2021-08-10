package com.moappdev.solutions.tronoapp.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moappdev.solutions.tronoapp.network.Thrones

class DetailViewModelFactory(val id: Thrones):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(id) as T
        throw IllegalArgumentException("no se pudo crear el Viewmodel")
    }
}