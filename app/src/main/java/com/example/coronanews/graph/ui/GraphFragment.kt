package com.example.coronanews.graph.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coronanews.R
import com.example.coronanews.graph.model.WorldStatisticsResponse

class GraphFragment : Fragment(), GraphContract.View {

    private val presenter = GraphPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_graph, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getWorldStatistics()

    }

    override fun showWorldStatistics(worldStatisticsDataItems: WorldStatisticsResponse.Global) {
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
