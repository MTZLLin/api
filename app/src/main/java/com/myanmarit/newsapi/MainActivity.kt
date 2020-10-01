package com.myanmarit.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myanmarit.newsapi.api.ApiClient
import com.myanmarit.newsapi.model.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiClient = ApiClient()
        var apiCall = apiClient.getEverything()
        apiCall.enqueue(object : Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                txtResult.text = t.toString()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                txtResult.text = response.body().toString()
            }
        })
    }
}