package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.SummaryStatisticsResponse
import io.reactivex.Single

class RemoteWorldStatisticsDataStore {

    private val retrofitStatisticsService
            by lazy { RetrofitStatisticsClient.statisticsWebService() }

    fun getWorldStatistics(): Single<SummaryStatisticsResponse.Global>{
        return retrofitStatisticsService.getStatistics().map { it.global }
    }

    fun getCountryStatistics(): Single<List<SummaryStatisticsResponse.Country>>{
        return retrofitStatisticsService.getStatistics().map { it.countries }
    }
}