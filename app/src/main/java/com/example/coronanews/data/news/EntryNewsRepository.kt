package com.example.coronanews.data.news

import com.example.coronanews.model.news.News
import io.reactivex.Single

class EntryNewsRepository {

    private val remoteDS = RemoteNewsDataSource()

    fun getNewsList(): Single<List<News>> {
        return remoteDS.getNewsList()
    }
}