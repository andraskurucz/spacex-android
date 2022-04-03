package com.akurucz.spacex.di

import com.akurucz.spacex.launch.data.LaunchRepositoryImpl
import com.akurucz.spacex.launch.model.LaunchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideLaunchRepository(repo: LaunchRepositoryImpl): LaunchRepository
}