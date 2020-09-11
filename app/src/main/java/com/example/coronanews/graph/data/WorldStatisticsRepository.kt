package com.example.coronanews.graph.data

import com.example.coronanews.graph.model.WorldStatisticsResponse
import io.reactivex.Single

class WorldStatisticsRepository {

    private val remoteDataStore = RemoteWorldStatisticsDataStore()

    fun getWorldStatistics(): Single<WorldStatisticsResponse.Global> {
        return remoteDataStore.getWorldStatistics()
    }
}