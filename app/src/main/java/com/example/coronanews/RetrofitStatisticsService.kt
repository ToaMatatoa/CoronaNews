package com.example.coronanews

import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitStatisticsService {

    @GET("summary")
    fun getCountryStatisticsList () : Single<List<WorldStatistics>>

}