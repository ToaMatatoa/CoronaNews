package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.WorldStatisticsResponse
import io.reactivex.Single

class RemoteWorldStatisticsDataStore {

    private val retrofitWorldStatisticsService
            by lazy { RetrofitStatisticsClient.statisticsWebService() }

    fun getWorldStatistics(): Single<WorldStatisticsResponse.Global>{
        return retrofitWorldStatisticsService.getWorldStatistics().map { it.data }
    }
}