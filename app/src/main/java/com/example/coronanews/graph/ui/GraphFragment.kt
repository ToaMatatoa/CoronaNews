package com.example.coronanews.graph.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coronanews.R
import com.example.coronanews.graph.model.CountryLiveResponse
import com.example.coronanews.graph.model.SummaryStatisticsResponse
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.data.*
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
        presenter.getCountryStatistics()
        presenter.getLiveStatistics()
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

    override fun showCountryStatistics(countryStatisticsDataItems: List<SummaryStatisticsResponse.Country>) {

        val legend = bar_chart.legend
        val legendEntryTotal = LegendEntry()
        legendEntryTotal.label = "Total"
        legendEntryTotal.formColor = resources.getColor(R.color.yellow)
        val legendEntryRecovered = LegendEntry()
        legendEntryRecovered.label = "Recovered"
        legendEntryRecovered.formColor = resources.getColor(R.color.orange)
        val legendEntryDied = LegendEntry()
        legendEntryDied.label = "Died"
        legendEntryDied.formColor = resources.getColor(R.color.red)
        val legendEntryTotalDay = LegendEntry()
        legendEntryTotalDay.label = "Total day"
        legendEntryTotalDay.formColor = resources.getColor(R.color.palegreen)
        val legendEntryRecoveredDay = LegendEntry()
        legendEntryRecoveredDay.label = "Recovered day"
        legendEntryRecoveredDay.formColor = resources.getColor(R.color.lightseagreen)
        val legendEntryDiedDay = LegendEntry()
        legendEntryDiedDay.label = "Died day"
        legendEntryDiedDay.formColor = resources.getColor(R.color.green)

        legend.form = Legend.LegendForm.CIRCLE
        legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.textSize = 10.5f
        legend.setCustom(
            listOf(
                legendEntryTotal,
                legendEntryRecovered,
                legendEntryDied,
                legendEntryTotalDay,
                legendEntryRecoveredDay,
                legendEntryDiedDay
            )
        )

        val entries: MutableList<BarEntry> = ArrayList()
        entries.add(BarEntry(1f, countryStatisticsDataItems[176].totalConfirmed.toFloat()))
        entries.add(BarEntry(2f, countryStatisticsDataItems[176].totalRecovered.toFloat()))
        entries.add(BarEntry(3f, countryStatisticsDataItems[176].totalDeaths.toFloat()))
        entries.add(BarEntry(4f, countryStatisticsDataItems[176].newConfirmed.toFloat()))
        entries.add(BarEntry(5f, countryStatisticsDataItems[176].newRecovered.toFloat()))
        entries.add(BarEntry(6f, countryStatisticsDataItems[176].newDeaths.toFloat()))
        val set = BarDataSet(entries, "")

        set.setColors(
            resources.getColor(R.color.yellow),
            resources.getColor(R.color.orange),
            resources.getColor(R.color.red),
            resources.getColor(R.color.palegreen),
            resources.getColor(R.color.lightseagreen),
            resources.getColor(R.color.green)
        )

        val data = BarData(set)
        data.setValueTextSize(11f)
        data.barWidth = 0.9f

        bar_chart.data = data
        bar_chart.setFitBars(true)
        bar_chart.invalidate()
        bar_chart.description.isEnabled = false
        bar_chart.animateXY(1000, 1000)
    }

    override fun showLiveStatistics(liveStatisticsDataItem: List<CountryLiveResponse>) {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}

