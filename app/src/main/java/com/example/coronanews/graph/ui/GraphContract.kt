package com.example.coronanews.graph.ui

import com.example.coronanews.graph.model.CountryLiveResponse
import com.example.coronanews.graph.model.SummaryStatisticsResponse

interface GraphContract {

    interface View {
        fun showWorldStatistics(worldStatisticsDataItems: SummaryStatisticsResponse.Global)
        fun showCountryStatistics(countryStatisticsDataItems: List<SummaryStatisticsResponse.Country>)
        fun showLiveStatistics(liveStatisticsDataItem: List<CountryLiveResponse>)
    }

    interface Presenter{
        fun getWorldStatistics()
        fun getCountryStatistics()
        fun getLiveStatistics()
        fun onDestroy()
    }

}