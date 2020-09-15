package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.Country
import com.example.coronanews.graph.model.CountryLiveResponse
import com.example.coronanews.graph.model.Global
import io.reactivex.Single
import java.util.*

class RemoteWorldStatisticsDataStore {

    private val retrofitWorldStatisticsService
            by lazy { RetrofitStatisticsClient.worldStatisticsService() }
    private val retrofitLiveStatisticsService
            by lazy { RetrofitStatisticsClient.liveStatisticsService() }

    fun getWorldStatistics(): Single<Pair<Global, Date>> {
        return retrofitWorldStatisticsService.getStatistics()
            .map {
                Pair(it.global, it.dateSummary)
            }
    }

    fun getCountryStatistics(): Single<List<Country>> {
        return retrofitWorldStatisticsService.getStatistics()
            .map {
                it.countries
            }
    }

    fun getLiveStatistics(): Single<List<CountryLiveResponse>> {
        return retrofitLiveStatisticsService.getLiveStatistics(
            from = "2020-08-01T00:00:00Z",
            to = "2020-08-09T00:00:00Z"
        )
    }
}