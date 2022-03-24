package com.example.texttalkmedia.presentation.di

import com.example.texttalkmedia.data.repository.NewsRepositoryImpl
import com.example.texttalkmedia.data.repository.datasource.NewsLocalDataSource
import com.example.texttalkmedia.data.repository.datasource.NewsRemoteDataSource
import com.example.texttalkmedia.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        userRemoteDataSource: NewsRemoteDataSource,
        userLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(userRemoteDataSource, userLocalDataSource)
    }
}