package com.example.coronanews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    private val items = listOf(
        "JetBrains/kotlin - The Kotlin Programming Language",
        "exercism/kotlin - Exercism exercises in Kotlin",
        "cbeust/kobalt - A Kotlin-based build system for the JVM",
        "JetBrains/kotlin - The Kotlin Programming Language",
        "exercism/kotlin - Exercism exercises in Kotlin",
        "cbeust/kobalt - A Kotlin-based build system for the JVM",
        "JetBrains/kotlin - The Kotlin Programming Language"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set recycler view
        rv_news.layoutManager = LinearLayoutManager(context)
        rv_news.adapter = AdapterNews(items)
    }
}
