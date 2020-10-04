package com.myanmarit.newsapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myanmarit.newsapi.api.ApiClient
import com.myanmarit.newsapi.model.News
import kotlinx.android.synthetic.main.api_fragment_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewmodel: ViewModel() {
    //live data= Immutable //Mutable Live Data
    private var news: MutableLiveData<News> = MutableLiveData()

    fun getArticle(): MutableLiveData<News> = news
    fun loadArticle() {
        var apiClient = ApiClient()
        var apiCall = apiClient.getEverything()
        apiCall.enqueue(
            object : Callback<News> {
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("Error>>>", t.toString())
                }

                override fun onResponse(call: Call<News>, response: Response<News>) {
                    news.value = response.body()
                }
            })
    }
}