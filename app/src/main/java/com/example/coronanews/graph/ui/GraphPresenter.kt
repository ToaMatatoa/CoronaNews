package com.example.coronanews.graph.ui

import android.util.Log
import com.example.coronanews.graph.data.WorldStatisticsRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GraphPresenter(private val view: GraphContract.View) : GraphContract.Presenter {

    private val worldStatisticsRepository =
        WorldStatisticsRepositoryProvider.worldStatisticsRepositoryProvider()
    private val compositeDisposable = CompositeDisposable()

    override fun getWorldStatistics() {
        compositeDisposable.add(
            worldStatisticsRepository.getWorldStatistics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showWorldStatistics(it)
                }, {
                    Log.getStackTraceString(it)
                }
                )
        )
    }

    override fun onDestroy() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}