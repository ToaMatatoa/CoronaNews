package com.example.coronanews.news.data

import com.example.coronanews.graph.data.RetrofitStatisticsService
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private const val newsURL = "https://covid-19-news.p.rapidapi.com/"
    private const val statisticsURL = "https://api.covid19api.com/"

    fun newsWebService(): RetrofitNewsService {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("X-RapidAPI-Host", "covid-19-news.p.rapidapi.com")
                    builder.header(
                        "X-RapidAPI-Key",
                        "1fb34b6850mshf697836118ae0aep110610jsn7c63a5dfe31c"
                    )
                    return@Interceptor chain.proceed((builder.build()))
                }
            )
            addInterceptor(NewsResponseInterceptor())
            addInterceptor(logging)
        }.build()

        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
        val retrofit = Retrofit.Builder()
            .baseUrl(newsURL)
            .client(okHttpClient.newBuilder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
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