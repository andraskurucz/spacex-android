package com.akurucz.spacex.launch.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface LaunchRepository {
    fun getLaunchStream(): Flow<PagingData<Launch>>
}