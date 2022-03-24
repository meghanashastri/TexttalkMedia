package com.example.texttalkmedia.presentation.di

import com.example.texttalkmedia.data.api.NewsApiService
import com.example.texttalkmedia.data.repository.datasource.NewsRemoteDataSource
import com.example.texttalkmedia.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(newsApiService: NewsApiService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }

}