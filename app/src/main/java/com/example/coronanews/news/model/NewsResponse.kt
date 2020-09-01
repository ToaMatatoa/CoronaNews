package com.example.coronanews.news.model

import com.google.gson.annotations.SerializedName
import java.util.*

class NewsResponse(@SerializedName("articles") var data: List<Article>) {

    data class Article(
        @SerializedName("id") val id: String,
        @SerializedName("source") val source: String,
        @SerializedName("link") val link: String,
        @SerializedName("publishedDate") val publishedDate: Date,
        @SerializedName("summary") val summary: String,
        @SerializedName("title") val title: String
    )
}