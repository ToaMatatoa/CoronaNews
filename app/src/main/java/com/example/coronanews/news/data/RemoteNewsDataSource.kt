package com.example.coronanews.news.data//package com.example.coronanews.data.newsDataItems

import com.example.coronanews.news.model.NewsResponse
import io.reactivex.Single

class RemoteNewsDataSource {

    private val retrofitNewsService by lazy { RetrofitClient.newsWebService() }

    fun getNewsList(): Single<List<NewsResponse.Article>> {
        return retrofitNewsService.getNewsList(
            country = "UA", topic = "news", language = "en",
            sortBy = "date", pageSize = 20, haveImage = true, pageNumber = 1, searchWord = "covid"
        ).map { it.data }
    }
}