package com.akurucz.spacex.di

import com.akurucz.spacex.launch.data.SpaceXService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    companion object {
        private const val CONNECT_TIME_OUT_SEC = 30
        private const val READ_TIME_OUT_SEC = 30
        private const val WRITE_TIME_OUT_SEC = 30
        private const val BASE_URL = "https://api.spacexdata.com"
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIME_OUT_SEC.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIME_OUT_SEC.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIME_OUT_SEC.toLong(), TimeUnit.SECONDS)
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().build()
                )
            )
            .client(httpClient)
            .build()
    }

    @Provides
    fun provideSpaceXService(): SpaceXService {
        return retrofit.create(SpaceXService::class.java)
    }
}
