package com.example.texttalkmedia.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.texttalkmedia.data.db.Database
import com.example.texttalkmedia.data.db.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): Database {
        return Room.databaseBuilder(app, Database::class.java, "texttalk_media_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: Database): NewsDao {
        return db.getNewsDAO()
    }
}