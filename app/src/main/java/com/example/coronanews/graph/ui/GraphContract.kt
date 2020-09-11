package com.example.coronanews.graph.ui

import com.example.coronanews.graph.model.WorldStatisticsResponse

interface GraphContract {

    interface View {
        fun showWorldStatistics(worldStatisticsDataItems: WorldStatisticsResponse)
    }

    interface Presenter{
        fun getWorldStatistics()
        fun onDestroy()
    }

}