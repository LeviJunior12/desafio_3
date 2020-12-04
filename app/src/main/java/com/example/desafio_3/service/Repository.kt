package com.example.desafio_3.service

import com.example.desafio_3.entity.marvel.ComicsWrapper
import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET("characters/{id}/comics")
    suspend fun getResults(
        @Path("id")id: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): ComicsWrapper
}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"

val retrofit = Retrofit.Builder()
    .baseUrl(urlApiMarvel)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service: Service = retrofit.create(Service::class.java)