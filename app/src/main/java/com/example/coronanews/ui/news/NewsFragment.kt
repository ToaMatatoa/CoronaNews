package com.example.coronanews.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coronanews.AdapterNews
import com.example.coronanews.News
import com.example.coronanews.R
import kotlinx.android.synthetic.main.fragment_news.*
import java.util.*

class NewsFragment : Fragment(), NewsContract.Fragment {

    private lateinit var newsAdapter : AdapterNews
//    private val presenter = NewsPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addToFavourite: (News) -> Unit = {}

        rv_news.layoutManager = LinearLayoutManager(context)
        newsAdapter = AdapterNews(addToFavourite)
        rv_news.adapter = newsAdapter

        val news = listOf(News("", "", "", Date(), "", ""))
        newsAdapter.addNews(news)

//        presenter.getNews()
    }

    override fun showNews(news: List<News>) {
        newsAdapter.addNews(news)
    }


}

