package com.example.coronanews.ui.news

import android.util.Log
import com.example.coronanews.data.news.EntryNewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsPresenter : NewsContract.Presenter {

    private val view = NewsFragment()
    private val entryNews = EntryNewsRepository()

    override fun getNews() {
        val repository = entryNews.getNewsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showNews(it)
            }, {
                Log.getStackTraceString(it)
            })
    }
}