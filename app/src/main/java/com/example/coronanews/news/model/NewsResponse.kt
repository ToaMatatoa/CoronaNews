package com.example.coronanews.news.model

import com.google.gson.annotations.SerializedName
import java.util.*

class NewsResponse(@SerializedName("result") var data: Properties) {

    data class Properties(@SerializedName("properties") var properties: Articles)

    data class Articles(@SerializedName("articles") var articles: List<Article>)

    data class Article(@SerializedName("items") val newsDataItems: NewsDataItems)

    data class NewsDataItems(
        @SerializedName("id") val id: String,
        @SerializedName("source") val source: String,
        @SerializedName("link") val link: String,
        @SerializedName("publishedDate") val publishedDate: Date,
        @SerializedName("summary") val summary: String,
        @SerializedName("title") val title: String
    )
}