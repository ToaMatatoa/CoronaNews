package com.example.coronanews.graph.model

import com.google.gson.annotations.SerializedName
import java.util.*

class CountryStatisticsResponse(
    @SerializedName("Countries") var data: List<Country>
) {

    data class Country(
        @SerializedName("Country") val country: String,
        @SerializedName("NewConfirmed") val newConfirmed: Int,
        @SerializedName("TotalConfirmed") val totalConfirmed: Int,
        @SerializedName("NewDeaths") val newDeaths: Int,
        @SerializedName("TotalDeaths") val totalDeaths: Int,
        @SerializedName("NewRecovered") val newRecovered: Int,
        @SerializedName("TotalRecovered") val totalRecovered: Int,
        @SerializedName("Date") val date: Date,
    )

}