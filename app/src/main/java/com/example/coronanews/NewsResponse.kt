package com.example.coronanews

import androidx.databinding.BaseObservable
import java.util.*

object NewsResponse {

    data class Result(val data: Articles)

    data class Articles(val article: List<Article>)

    data class Article(val data: Data)

    data class Data(
        val id: String, val source: String, val link: String,
        val publishedDate: Date, val summary: String, val title: String
    ) : BaseObservable() {
    }
}