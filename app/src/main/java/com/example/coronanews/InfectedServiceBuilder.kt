package com.example.coronanews

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InfectedServiceBuilder {

    private val url = "https://api.covid19api.com/countries"
    // created http client
    private val okHttp = OkHttpClient.Builder()

    //retrofit builder
    private val builder = Retrofit.Builder().baseUrl(url)
        .addConverterFactory((GsonConverterFactory.create()))
        .client(okHttp.build())

    //retrofit instance
    private val retrofit = builder.build()

    fun <T> buildService (serviceType :Class<T>):T{
        return retrofit.create(serviceType)
    }
}