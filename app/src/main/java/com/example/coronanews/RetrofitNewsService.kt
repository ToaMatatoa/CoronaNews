package com.example.coronanews

import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitNewsService {

    @GET ("v1/covid?topic=news&lang=ru&sort_by=date&page_size=20&media=True&country=UA&page=1&q=covid")
    fun getNewsList() : Single<List<News>>

}