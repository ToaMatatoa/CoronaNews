package com.example.coronanews

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val newsURL = "https://covid-19-news.p.rapidapi.com/"
    private const val statisticsURL = "https://api.covid19api.com/"

    fun newsWebService(): RetrofitNewsService {
        val retrofit = Retrofit.Builder()
            .baseUrl(newsURL)
            .client(OkHttpClient().newBuilder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RetrofitNewsService::class.java)
    }

    fun statisticsWebService(): RetrofitStatisticsService {
        val retrofit = Retrofit.Builder()
            .baseUrl(statisticsURL)
            .client(OkHttpClient().newBuilder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RetrofitStatisticsService::class.java)
    }
}