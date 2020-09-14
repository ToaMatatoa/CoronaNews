package com.example.coronanews.graph.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coronanews.R
import com.example.coronanews.graph.model.SummaryStatisticsResponse
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_graph.*


@Suppress("DEPRECATION")
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

    override fun showWorldStatistics(worldStatisticsDataItems: SummaryStatisticsResponse.Global) {

        val entries: MutableList<PieEntry> = ArrayList()
        entries.add(PieEntry(worldStatisticsDataItems.totalConfirmed.toFloat(), "Total"))
        entries.add(PieEntry(worldStatisticsDataItems.totalRecovered.toFloat(), "Recovered"))
        entries.add(PieEntry(worldStatisticsDataItems.totalDeaths.toFloat(), "Died"))

        val dataSet = PieDataSet(entries, "")
        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        val data = PieData(dataSet)
        pie_chart.data = data
        data.setValueTextSize(11f)
        pie_chart.animateXY(1000, 1000)
        pie_chart.invalidate()
        pie_chart.description.isEnabled = false
        pie_chart.setDrawSliceText(false)
        val l: Legend = pie_chart.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}

