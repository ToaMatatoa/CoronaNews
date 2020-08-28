package com.example.coronanews

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronanews.model.news.News
import kotlinx.android.synthetic.main.news_list_item.view.*
import java.text.SimpleDateFormat

class AdapterNews(private val listener: (News) -> Unit) :
    RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    private val items = mutableListOf<News>()

    fun addNews(news: List<News>) {
        items.addAll(news)
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
        private val dateFormatter = "DD.MM K:mm"
        fun bind(item: News, listener: (News) -> Unit) = with(itemView) {
            tv_source.text = item.source
            tv_title.text = item.title
            tv_date.text = SimpleDateFormat(dateFormatter).format(item.publishedDate)
            setOnClickListener { listener(item) }
        }
    }
}