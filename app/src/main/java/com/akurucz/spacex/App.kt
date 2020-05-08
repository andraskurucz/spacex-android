package com.akurucz.spacex

import android.app.Application
import com.akurucz.spacex.di.AppComponent
import com.akurucz.spacex.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}