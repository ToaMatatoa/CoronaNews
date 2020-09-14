package com.example.coronanews.graph.ui

import com.example.coronanews.graph.model.SummaryStatisticsResponse

interface GraphContract {

    interface View {
        fun showWorldStatistics(worldStatisticsDataItems: SummaryStatisticsResponse.Global)
    }

    interface Presenter{
        fun getWorldStatistics()
        fun onDestroy()
    }

}