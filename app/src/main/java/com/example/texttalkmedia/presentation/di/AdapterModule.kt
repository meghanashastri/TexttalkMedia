package com.example.texttalkmedia.presentation.di

import com.example.texttalkmedia.presentation.adapter.NewsListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideUserAdapter(): NewsListAdapter {
        return NewsListAdapter()
    }
}