package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.WorldStatisticsResponse
import io.reactivex.Single

class RemoteWorldStatisticsDataSource {

    private val retrofitWorldStatisticsService
            by lazy { RetrofitStatisticsClient.statisticsWebService() }

    fun getWorldStatistics(): Single<WorldStatisticsResponse>{
        return retrofitWorldStatisticsService.getWorldStatistics(
            worldStatistics = "summary"
        )
    }
}