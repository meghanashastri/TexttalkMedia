package com.example.texttalkmedia.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "news"
)
data class Article(
    @ColumnInfo(name = "article_id")
    @PrimaryKey(autoGenerate = true)
    val article_id: Int,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable