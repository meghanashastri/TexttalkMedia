package com.example.texttalkmedia.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.texttalkmedia.data.model.Article;
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<Article>)

    @Query("SELECT * FROM news")
    fun getAllNews(): Flow<List<Article>>

    @Query("DELETE FROM news")
    suspend fun deleteAllNews()
}
