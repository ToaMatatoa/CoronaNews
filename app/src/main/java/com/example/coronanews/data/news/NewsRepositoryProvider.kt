package com.example.coronanews.data.news

object NewsRepositoryProvider {
    fun newsRepositoryProvider(): EntryNewsRepository {
        return EntryNewsRepository()
    }
}