package com.akurucz.spacex.launch.model

import com.akurucz.spacex.launch.model.Launch

interface LaunchRepository {
    suspend fun getLaunches(): List<Launch>
}