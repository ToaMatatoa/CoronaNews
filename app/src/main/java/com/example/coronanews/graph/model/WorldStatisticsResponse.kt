package com.example.coronanews.graph.model

import com.google.gson.annotations.SerializedName

class WorldStatisticsResponse(@SerializedName("Global") val data: Global) {

    data class Global(
        @SerializedName("NewConfirmed") val newConfirmed: Int,
        @SerializedName("NewDeaths") val newDeaths: Int,
        @SerializedName("NewRecovered") val newRecovered: Int,
        @SerializedName("TotalConfirmed") val totalConfirmed: Int,
        @SerializedName("TotalDeaths") val totalDeaths: Int,
        @SerializedName("TotalRecovered") val totalRecovered: Int
    )

}