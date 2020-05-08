package com.akurucz.spacex.launch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akurucz.spacex.launch.model.Launch
import com.akurucz.spacex.launch.model.LaunchRepository
import java.lang.Exception
import javax.inject.Inject

class LaunchViewModel @Inject constructor(repository: LaunchRepository) : ViewModel() {

    val launches: LiveData<List<Launch>> = liveData {
        try {
            val launches = repository.getLaunches()
            emit(launches)
        } catch (e: Exception) {
            emit(emptyList<Launch>())
        }
    }
}