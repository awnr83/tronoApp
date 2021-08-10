package com.moappdev.solutions.tronoapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val url="https://610ef19d7f793c0017419630.mockapi.io/"

private val moshi= Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit= Retrofit
    .Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(url)
    .build()

interface ThronesApiService{
    @GET("personajes")
    suspend fun obtenerPersonajes():List<Thrones>
}

object ThronesApi{
    val retrofitService: ThronesApiService by lazy{
        retrofit.create(ThronesApiService::class.java)
    }
}