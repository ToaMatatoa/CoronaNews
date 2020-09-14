package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.SummaryStatisticsResponse
import io.reactivex.Single

class WorldStatisticsRepository {

    private val remoteDataStore = RemoteWorldStatisticsDataStore()

    fun getWorldStatistics(): Single<SummaryStatisticsResponse.Global> {
        return remoteDataStore.getWorldStatistics()
    }
}