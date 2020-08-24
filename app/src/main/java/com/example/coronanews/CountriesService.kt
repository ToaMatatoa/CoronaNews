package com.example.coronanews

import retrofit2.Call
import retrofit2.http.GET

interface CountriesService {

    @GET("countries")
    fun getCountryList () : Call<List<CountryInfo>>

}