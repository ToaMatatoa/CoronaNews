package com.example.coronanews.news.model

import java.util.*

data class NewsDataItems(
    val id: String? = "",
    val source: String? = "",
    val link: String? = "",
    val publishedDate: Date = Date(),
    val summary: String? = "",
    val title: String? = ""
)