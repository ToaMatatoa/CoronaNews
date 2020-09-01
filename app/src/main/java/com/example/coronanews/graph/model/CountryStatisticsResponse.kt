package com.example.coronanews.graph.model

import androidx.databinding.BaseObservable
import java.util.*

object CountryStatisticsResponse {

    data class Result(val data: Country)

    data class Country(val data: List<Data>)

    data class Data(
        val Active: Int, val Confirmed: Int, val Country: String,
        val Date: Date, val Deaths: Int, val Recovered: Int
    ) : BaseObservable() {
    }
}