package com.akurucz.spacex.launch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akurucz.spacex.launch.model.Launch
import com.akurucz.spacex.launch.model.LaunchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LaunchViewModel @Inject constructor(private val repository: LaunchRepository) : ViewModel() {

    @Volatile
    private var currentLaunches: Flow<PagingData<Launch>>? = null

    val launchesStream: Flow<PagingData<Launch>> by lazy { repository.getLaunchStream().cachedIn(viewModelScope) }

    fun getStream(): Flow<PagingData<Launch>> {
        return repository.getLaunchStream().cachedIn(viewModelScope)
    }
}