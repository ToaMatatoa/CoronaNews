package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.WorldStatisticsResponse
import io.reactivex.Single

class WorldStatisticsRepository {

    private val remoteDataStore = RemoteWorldStatisticsDataSource()

    fun getWorldStatistics(): Single<WorldStatisticsResponse> {
        return remoteDataStore.getWorldStatistics()
    }
}