package com.example.coronanews.news.data

import okhttp3.Interceptor
import okhttp3.Response

class NewsResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        return response.newBuilder()
            .addHeader("Content-Type", "application/json; charset=utf-8-text")
            .build()
    }
}