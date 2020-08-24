package com.example.coronanews

data class Country(
    val Country: String,
    val CountryCode: String,
    val CountryInfo: CountryInfo,
    val Date: String,
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val Slug: String,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)