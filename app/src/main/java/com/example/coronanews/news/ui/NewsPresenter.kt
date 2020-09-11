package com.example.coronanews.news.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.coronanews.news.data.NewsRepositoryProvider
import com.example.coronanews.news.model.NewsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsPresenter(private val view: NewsContract.View) : NewsContract.Presenter {

    private val newsRepository = NewsRepositoryProvider.newsRepositoryProvider()
    private val compositeDisposable = CompositeDisposable()
    var entries = MutableLiveData<ArrayList<NewsResponse.Article>>()

    override fun getNews() {
        compositeDisposable.add(
            newsRepository.getNewsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showNews(it)
                }, {
                    Log.getStackTraceString(it)
                })
        )
    }

    override fun onDestroy() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}