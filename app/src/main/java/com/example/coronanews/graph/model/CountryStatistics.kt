package com.example.coronanews.graph.model

import java.util.*

data class CountryStatistics(
    val Active: Int = 0,
    val Confirmed: Int = 0,
    val Country: String = "",
    val Date: Date = Date(),
    val Deaths: Int = 0,
    val Recovered: Int = 0
)