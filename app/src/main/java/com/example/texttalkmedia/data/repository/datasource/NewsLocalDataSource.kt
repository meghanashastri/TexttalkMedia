package com.example.texttalkmedia.data.repository.datasource

import com.example.texttalkmedia.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    fun getNews(): Flow<List<Article>>

    suspend fun deleteAllNews()

    suspend fun insertNews(users: List<Article>)

    suspend fun deleteAndInsertNews(users: List<Article>)
}