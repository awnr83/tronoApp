package com.moappdev.solutions.tronoapp.detalle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moappdev.solutions.tronoapp.network.House
import com.moappdev.solutions.tronoapp.network.Thrones

class DetailViewModel(val item:Thrones): ViewModel(){

    private val _personaje= MutableLiveData<Thrones>()
    val personaje: LiveData<Thrones>
        get()= _personaje

    private val _material= MutableLiveData<Array<Int>>()
    val material: LiveData<Array<Int>>
        get()= _material

    private val _onBtn= MutableLiveData<House>()
    val onBtn: LiveData<House>
        get()= _onBtn

    fun onWords(){
        _onBtn.value= _personaje.value!!.house
    }
    fun onWordsC(){
        _onBtn.value=null
    }


    init {
        _onBtn.value=null
       _personaje.value= item
        _material.value= House.getMaterial(item.house.name!!)
    }
}