package com.example.coronanews

import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("countries")
    fun getCountryList () : Single<List<CountryInfo>>

}