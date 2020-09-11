package com.example.coronanews.graph.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitStatisticsClient {

    private const val statisticsURL = "https://api.covid19api.com/"

    fun statisticsWebService(): RetrofitStatisticsService {

        val gson = GsonBuilder().setDateFormat("YYYY-MM-DDTHH:MM:SSZ").create()
        val retrofit = Retrofit.Builder()
            .baseUrl(statisticsURL)
            .client(OkHttpClient().newBuilder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(RetrofitStatisticsService::class.java)
    }
}