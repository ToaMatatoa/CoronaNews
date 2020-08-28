package com.example.coronanews.ui.news

import com.example.coronanews.News
import java.util.*

class NewsPresenter : NewsContract.Presenter {
    private val view = NewsFragment()
    private val newsList = ArrayList<News>()

    override fun getNews() {
        //todo get date from GetNewsUseCase -> NewsRepository -> RemoteNewsDataStore
    }

}