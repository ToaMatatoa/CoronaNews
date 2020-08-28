package com.example.coronanews.data.news

import com.example.coronanews.model.news.News
import io.reactivex.Single

class EntryNews {

    private val remoteDS = RemoteDataSource()

    fun getNewsList(): Single<List<News>>{
        return remoteDS.getNewsList()
    }
}