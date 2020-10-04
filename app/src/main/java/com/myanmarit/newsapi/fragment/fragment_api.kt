package com.myanmarit.newsapi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.myanmarit.newsapi.NewsAdapter
import com.myanmarit.newsapi.R
import com.myanmarit.newsapi.api.ApiClient
import com.myanmarit.newsapi.model.ArticlesItem
import com.myanmarit.newsapi.model.News
import com.myanmarit.newsapi.viewmodel.HomeViewmodel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.api_fragment_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class fragment_api : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.api_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var homeViewmodel = ViewModelProvider(this).get(HomeViewmodel::class.java)

        var newsAdapter = NewsAdapter()
        newsRecyclerView.layoutManager = LinearLayoutManager(context)
        newsRecyclerView.adapter = newsAdapter

        homeViewmodel.loadArticle()
        homeViewmodel.getArticle().observe(
            viewLifecycleOwner, Observer { news ->
                newsAdapter.updateArticle(news.articles as List<ArticlesItem>)
            }
        )
            }
}