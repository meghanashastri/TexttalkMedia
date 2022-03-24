package com.example.texttalkmedia.presentation.di

import com.example.texttalkmedia.data.db.Database
import com.example.texttalkmedia.data.db.NewsDao
import com.example.texttalkmedia.data.repository.datasource.NewsLocalDataSource
import com.example.texttalkmedia.data.repository.datasourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideUserLocalDataSource(db: Database, newsDao: NewsDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(db, newsDao)
    }
}