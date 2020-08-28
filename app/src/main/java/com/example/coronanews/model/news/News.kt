package com.example.coronanews.model.news

import java.util.*

data class News(
    val id: String? = "",
    val source: String? = "",
    val link: String? = "",
    val publishedDate: Date = Date(),
    val summary: String? = "",
    val title: String? = ""
)