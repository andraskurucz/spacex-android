package com.akurucz.spacex.launch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akurucz.spacex.launch.model.LaunchRepository
import javax.inject.Inject

class LaunchViewModelFactory @Inject constructor(private val repository: LaunchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LaunchViewModel(repository) as T
    }
}