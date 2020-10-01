package com.myanmarit.newsapi.api

import com.myanmarit.newsapi.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {
    private val BASE_URL = "http://newsapi.org/v2/"

    val apiInterface: NewsApiInterface
    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            NewsApiInterface::class.java
        )
    }

    fun getEverything(): Call<News>{
        return apiInterface.getEverything(
            "bitcoin",
            "31f0048a432848d6b08eaa7f95960f25"
        )
    }
}