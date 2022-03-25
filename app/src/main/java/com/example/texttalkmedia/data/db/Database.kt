package com.example.texttalkmedia.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.texttalkmedia.data.model.Article

@Database(
    entities = [Article::class],
    version = 7,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun getNewsDAO(): NewsDao
}