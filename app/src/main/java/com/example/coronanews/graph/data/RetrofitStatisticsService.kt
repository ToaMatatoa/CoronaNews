package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.SummaryStatisticsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitStatisticsService {

    @GET("summary")
    fun getStatistics () : Single<SummaryStatisticsResponse>

}