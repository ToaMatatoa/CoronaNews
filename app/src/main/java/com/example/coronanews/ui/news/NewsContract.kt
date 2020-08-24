package com.example.coronanews.ui.news

import com.example.coronanews.News

interface NewsContract {

    interface Fragment {
        fun showNews(news: List<News>)
    }

    interface Presenter {
        fun getNews()
    }
}