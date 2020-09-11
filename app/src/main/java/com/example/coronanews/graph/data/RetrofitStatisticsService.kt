package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.WorldStatisticsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitStatisticsService {

    @GET("summary")
    fun getWorldStatistics () : Single<WorldStatisticsResponse>

}