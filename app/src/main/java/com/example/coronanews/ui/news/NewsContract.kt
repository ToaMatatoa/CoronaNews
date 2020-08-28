package com.example.coronanews.ui.news

import com.example.coronanews.model.news.News

interface NewsContract {

    interface Fragment {
        fun showNews(news: List<News>)
    }

    interface Presenter {
        fun getNews()
    }
}