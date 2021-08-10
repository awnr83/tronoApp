package com.moappdev.solutions.tronoapp.personajes

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moappdev.solutions.tronoapp.model.Character
import com.moappdev.solutions.tronoapp.network.Thrones
import com.moappdev.solutions.tronoapp.network.ThronesApiService
import com.moappdev.solutions.tronoapp.repository.CharacterRepo
import kotlinx.coroutines.launch

class PersonajeViewModel(): ViewModel() {
    private val _personajes= MutableLiveData<List<Thrones>>()
    val personajes: LiveData<List<Thrones>>
        get()=_personajes

    private val _list= MutableLiveData<Int>()
    val list: LiveData<Int>
        get()=_list
    private val _load= MutableLiveData<Int>()
    val load: LiveData<Int>
        get()=_load
    private val _error= MutableLiveData<Int>()
    val error: LiveData<Int>
        get()=_error

    init {
        _load.value=View.VISIBLE
        _error.value=View.GONE
        _list.value=View.GONE
        viewModelScope.launch {
            try {
                _personajes.value =CharacterRepo().getPersonajes()
                _list.value=View.VISIBLE
                _load.value=View.GONE
            }catch (e:Exception){
                _error.value=View.VISIBLE
                _load.value=View.GONE
            }
        }
    }

    fun retry(){
        _load.value=View.VISIBLE
        _error.value=View.GONE
        _list.value=View.GONE
        viewModelScope.launch {
            try {
                _personajes.value =CharacterRepo().getPersonajes()
                _list.value=View.VISIBLE
                _load.value=View.GONE
            }catch (e:Exception){
                _error.value=View.VISIBLE
                _load.value=View.GONE
            }
        }
    }
}