package com.example.texttalkmedia.data.repository.datasourceImpl

import androidx.room.withTransaction
import com.example.texttalkmedia.data.db.Database
import com.example.texttalkmedia.data.db.NewsDao
import com.example.texttalkmedia.data.model.Article
import com.example.texttalkmedia.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val db: Database,
    private val newsDao: NewsDao
) : NewsLocalDataSource {

    override fun getNews(): Flow<List<Article>> {
        return newsDao.getAllNews()
    }

    override suspend fun deleteAllNews() {
        newsDao.deleteAllNews()
    }

    override suspend fun insertNews(news: List<Article>) {
        newsDao.insertNews(news)
    }

    override suspend fun deleteAndInsertNews(news: List<Article>) {
        db.withTransaction {
            deleteAllNews()
            insertNews(news)
        }
    }
}