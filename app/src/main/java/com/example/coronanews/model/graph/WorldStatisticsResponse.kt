package com.example.coronanews.model.graph

import androidx.databinding.BaseObservable

object WorldStatisticsResponse {

    data class Result(val data: Global)

    data class Global(val data: List<Data>)

    data class Data(
        val NewConfirmed: Int, val NewDeaths: Int, val NewRecovered: Int,
        val TotalConfirmed: Int, val TotalDeaths: Int, val TotalRecovered: Int
    ) : BaseObservable() {
    }
}