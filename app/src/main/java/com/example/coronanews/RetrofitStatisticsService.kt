package com.example.coronanews

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitStatisticsService {

    @GET("summary")
    fun getWorldStatisticsList (
        @Query("summary") worldStatistics: String
    ) : Single<List<WorldStatistics>>

    @GET("live/country/europe/status/confirmed")
    fun getCountryStatisticsList(
        @Query("live") live: Boolean,
        @Query("country") country: String,
        @Query("europe") continent: String,
        @Query("status") status: String,
        @Query("confirmed") confirmed: Boolean
    ) : Single<List<CountryStatistics>>
}