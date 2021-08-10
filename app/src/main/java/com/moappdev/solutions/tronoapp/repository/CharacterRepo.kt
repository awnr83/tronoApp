package com.moappdev.solutions.tronoapp.repository

import com.moappdev.solutions.tronoapp.network.Thrones
import com.moappdev.solutions.tronoapp.network.ThronesApi

//repositorio online
private lateinit var personajes: List<Thrones>

class CharacterRepo {
    suspend fun getPersonajes(): List<Thrones>{
        try{
            personajes= ThronesApi.retrofitService.obtenerPersonajes()
        }catch (e: Exception){

        }
        return personajes
    }
    fun obtenerPersonaje(id: String): Thrones? {
       return personajes.find {
            it.id==id
        }
    }
}


/*
//Repositorio para prueba local
object CharacterRepo {
    val character= mutableListOf<Character>()
            get() {
                if(field.isEmpty())
                    field.addAll(dummyCharacter())
                return field
            }

    private fun dummyCharacter(): MutableList<Character> {
        return (1..10).map {
            Character(
                name= "name ${it}",
                title= "title ${it}",
                born= "bron ${it}",
                actor = "actor ${it}",
                quote= "qoute ${it}",
                father="father ${it}",
                mother="mother ${it}",
                spouse= "spouse ${it}",
                house = House(
                    name= dummyHouse(),
                    region="region ${it}",
                    words= "words ${it}"
                )
            )
        }.toMutableList()
    }

    fun obtenerPersonaje(id: String): Character? {
        return character.find {
            it.id==id
        }
    }

    private fun dummyHouse():String{
        val name= arrayOf("stark", "lannister", "tyrell", "arryn", "targaryen", "martell", "baratheon", "greyjoy", "frey", "tully")
        var randomIdPosition= java.util.Random().nextInt(name.size)
        return name[randomIdPosition]
    }
}
*/