package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.CountryLiveResponse
import com.example.coronanews.graph.model.SummaryStatisticsResponse
import io.reactivex.Single

class StatisticsRepository {

    private val remoteDataStore =
        RemoteWorldStatisticsDataStoreProvider().remoteWorldStatisticsDataStoreProvider()

    fun getWorldStatistics(): Single<SummaryStatisticsResponse.Global> {
        return remoteDataStore.getWorldStatistics()
    }

    fun getCountryStatistics(): Single<List<SummaryStatisticsResponse.Country>> {
        return remoteDataStore.getCountryStatistics()
    }

    fun getLiveStatistics(): Single<List<CountryLiveResponse>> {
        return remoteDataStore.getLiveStatistics()
    }
}