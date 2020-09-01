package com.example.coronanews.news.data

import com.example.coronanews.news.model.NewsDataItems
import io.reactivex.Single

class NewsRepository {

    private val remoteDS = RemoteNewsDataSource()

    fun getNewsList(): Single<List<NewsDataItems>> {
        return remoteDS.getNewsList()
    }
}