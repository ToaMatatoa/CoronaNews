package com.example.coronanews.ui.news

import com.example.coronanews.News
import java.util.*

class NewsPresenter : NewsContract.Presenter {
    private val view = NewsFragment()

    override fun getNews() {
        //todo get date from GetNewsUseCase -> NewsRepository -> RemoteNewsDataStore


        val news = listOf(News("", "", "", Date(), "", "")) //todo remove this line!!!!!!!!!!!!!!!!!!!!!


        view.showNews(news)
    }

}