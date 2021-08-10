package com.moappdev.solutions.tronoapp.model

import com.moappdev.solutions.tronoapp.R
import java.util.*

data class Character(
    var id: String= UUID.randomUUID().toString(),
    var name: String,
    var born: String,
    var title:String,
    var actor: String,
    var quote: String,
    var father: String,
    var mother: String,
    var spouse: String,
    var house: House
)

data class House (
    var name: String,
    var region: String,
    var words: String
){
    companion object {

        private val defaultMaterial= arrayOf(R.color.starkOverlay, R.color.starkBase,R.drawable.ic_tully)

        private val material = mapOf(
            Pair("stark", arrayOf(R.color.starkOverlay, R.color.starkBase,R.drawable.ic_stark)),
            Pair("lannister", arrayOf(R.color.lannisterOVerlay, R.color.lannisterBase,R.drawable.ic_lannister)),
            Pair("tyrell", arrayOf(R.color.tyrellOVerlay, R.color.tyrellBase,R.drawable.ic_tyrell)),
            Pair("arryn", arrayOf(R.color.arrynOVerlay, R.color.arrynBase,R.drawable.ic_arryn)),
            Pair("targaryen", arrayOf(R.color.targaryenOVerlay, R.color.targaryenBase,R.drawable.ic_targaryen)),
            Pair("martell", arrayOf(R.color.martellOVerlay, R.color.martellBase,R.drawable.ic_martell)),
            Pair("baratheon", arrayOf(R.color.baratheonOVerlay, R.color.baratheonBase,R.drawable.ic_baratheon)),
            Pair("greyjoy", arrayOf(R.color.greyjoyOVerlay, R.color.greyjoyBase,R.drawable.ic_greyjoy)),
            Pair("frey", arrayOf(R.color.freyOVerlay, R.color.freyBase,R.drawable.ic_frey)),
            Pair("tully", arrayOf(R.color.turryOVerlay, R.color.tullyBase,R.drawable.ic_tully))
        )

        fun getMaterial(name: String):Array<Int>{
            return material.getOrDefault(name, defaultMaterial)
        }
    }
}
