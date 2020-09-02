package com.example.coronanews.news.model

import com.google.gson.annotations.SerializedName
import java.util.*

class NewsResponse(@SerializedName("articles") var data: List<Article>) {

    data class Article(
        @SerializedName("_id") val id: String,
        @SerializedName("clean_url") val source: String,
        @SerializedName("link") val link: String,
        @SerializedName("published_date") val publishedDate: Date,
        @SerializedName("summary") val summary: String,
        @SerializedName("title") val title: String
    )
}