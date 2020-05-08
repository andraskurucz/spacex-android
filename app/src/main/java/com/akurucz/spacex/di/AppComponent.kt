package com.akurucz.spacex.di

import com.akurucz.spacex.launch.ui.LaunchListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(fragment: LaunchListFragment)
}