package com.moappdev.solutions.tronoapp.network

import android.os.Parcelable
import com.moappdev.solutions.tronoapp.R
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.*

@Parcelize
@JsonClass(generateAdapter = true)
data class Thrones(
    val id: String?=null,
    val name: String?=null,
    val born: String?=null,
    val title:String?=null,
    val actor: String?=null,
    val quote: String?=null,
    val father: String?=null,
    val mother: String?=null,
    val spouse: String?=null,
    val img: String?=null,
    val house: @RawValue House
):Parcelable

@Parcelize
@Json(name="house")
data class House (
    val name: String?=null,
    val region: String?=null,
    val words: String?=null,
    val img: String?=null
):Parcelable{
    companion object {

        private val defaultMaterial= arrayOf(R.color.starkOverlay, R.color.starkBase, R.drawable.ic_tully)

        private val material = mapOf(
            Pair("stark", arrayOf(R.color.starkOverlay, R.color.starkBase, R.drawable.ic_stark)),
            Pair("lannister", arrayOf(R.color.lannisterOVerlay, R.color.lannisterBase, R.drawable.ic_lannister)),
            Pair("tyrell", arrayOf(R.color.tyrellOVerlay, R.color.tyrellBase, R.drawable.ic_tyrell)),
            Pair("arryn", arrayOf(R.color.arrynOVerlay, R.color.arrynBase, R.drawable.ic_arryn)),
            Pair("targaryen", arrayOf(R.color.targaryenOVerlay, R.color.targaryenBase, R.drawable.ic_targaryen)),
            Pair("martell", arrayOf(R.color.martellOVerlay, R.color.martellBase, R.drawable.ic_martell)),
            Pair("baratheon", arrayOf(R.color.baratheonOVerlay, R.color.baratheonBase, R.drawable.ic_baratheon)),
            Pair("greyjoy", arrayOf(R.color.greyjoyOVerlay, R.color.greyjoyBase, R.drawable.ic_greyjoy)),
            Pair("frey", arrayOf(R.color.freyOVerlay, R.color.freyBase, R.drawable.ic_frey)),
            Pair("tully", arrayOf(R.color.turryOVerlay, R.color.tullyBase, R.drawable.ic_tully))
        )

        fun getMaterial(name: String):Array<Int>{
            return material.getOrDefault(name, defaultMaterial)
        }
    }
}
