package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.CountryLiveResponse
import com.example.coronanews.graph.model.SummaryStatisticsResponse
import io.reactivex.Single

class RemoteWorldStatisticsDataStore {

    private val retrofitWorldStatisticsService
            by lazy { RetrofitStatisticsClient.worldStatisticsService() }
    private val retrofitLiveStatisticsService by lazy { RetrofitStatisticsClient.liveStatisticsService() }

    fun getWorldStatistics(): Single<SummaryStatisticsResponse.Global> {
        return retrofitWorldStatisticsService.getStatistics().map { it.global }
    }

    fun getCountryStatistics(): Single<List<SummaryStatisticsResponse.Country>> {
        return retrofitWorldStatisticsService.getStatistics().map { it.countries }
    }

    fun getLiveStatistics(): Single<List<CountryLiveResponse>> {
        return retrofitLiveStatisticsService.getLiveStatistics(
            from = "2020-08-01T00:00:00Z",
            to = "2020-08-09T00:00:00Z"
        )
    }
}