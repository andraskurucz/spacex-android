package com.akurucz.spacex.di

import com.akurucz.spacex.launch.data.LaunchRepositoryImpl
import com.akurucz.spacex.launch.model.LaunchRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideLaunchRepository(repo: LaunchRepositoryImpl): LaunchRepository
}