package com.example.coronanews

import com.example.coronanews.model.news.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitNewsService {

    @GET("v1/covid")
    fun getNewsList(
        @Query("topic") topic: String,
        @Query("lang") language: String,
        @Query("sort_by") sortBy: String,
        @Query("page_size") pageSize: Int,
        @Query("media") haveImage: Boolean,
        @Query("country") country: String,
        @Query("page") pageNumber: Int,
        @Query("q") searchWord: String
    ): Single<List<News>>


}