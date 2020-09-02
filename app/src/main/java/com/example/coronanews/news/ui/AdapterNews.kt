package com.example.coronanews.news.ui

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronanews.R
import com.example.coronanews.news.model.NewsResponse
import kotlinx.android.synthetic.main.news_list_item.view.*
import java.text.SimpleDateFormat

class AdapterNews(private val listener: (NewsResponse.Article) -> Unit) :
    RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    private val items = mutableListOf<NewsResponse.Article>()

    fun addNews(newsDataItems: List<NewsResponse.Article>) {
        items.addAll(newsDataItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        View.inflate(parent.context, R.layout.news_list_item, null)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dateFormatter = "MM-dd HH:mm"

        @SuppressLint("SimpleDateFormat")
        fun bind(item: NewsResponse.Article, listener: (NewsResponse.Article) -> Unit) =
            with(itemView) {
                tv_source.text = item.source
                tv_title.text = item.title
                tv_date.text = SimpleDateFormat(dateFormatter).format(item.publishedDate)
                setOnClickListener { listener(item) }
            }
    }
}