package com.example.coronanews.data.news

import com.example.coronanews.RetrofitClient
import com.example.coronanews.model.news.News
import io.reactivex.Single

class RemoteDataSource {

    private val retrofitNewsService by lazy {RetrofitClient.newsWebService()}

    fun getNewsList(): Single<List<News>> {
        return retrofitNewsService.getNewsList(country = "UA", topic = "news", language = "ru",
            sortBy = "date", pageSize = 20, haveImage = true, pageNumber = 1, searchWord = "covid")
    }
}