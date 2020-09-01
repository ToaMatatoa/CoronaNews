package com.example.coronanews.news.data

import com.example.coronanews.news.model.NewsResponse
import io.reactivex.Single

class NewsRepository {

    private val remoteDS = RemoteNewsDataSource()

    fun getNewsList(): Single<List<NewsResponse.Article>> {
        return remoteDS.getNewsList()
    }
}