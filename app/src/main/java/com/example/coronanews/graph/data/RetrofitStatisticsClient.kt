package com.example.coronanews.graph.data

import com.example.coronanews.news.data.RetrofitResponseInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitStatisticsClient {

    private const val statisticsURL = "https://api.covid19api.com/"

    fun statisticsWebService(): RetrofitStatisticsService {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(RetrofitResponseInterceptor())
            addInterceptor(logging)
        }.build()

        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create()
        val retrofit = Retrofit.Builder()
            .baseUrl(statisticsURL)
            .client(okHttpClient.newBuilder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(RetrofitStatisticsService::class.java)
    }
}