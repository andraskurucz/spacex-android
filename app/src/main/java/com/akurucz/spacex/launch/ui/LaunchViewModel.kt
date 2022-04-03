package com.akurucz.spacex.launch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import com.akurucz.spacex.launch.model.LaunchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(private val repository: LaunchRepository) : ViewModel() {

    val launchesStream: Flow<PagingData<ListItem>> by lazy {
        repository.getLaunchStream()
            .map { pagingData -> pagingData.map { ListItem.LaunchItem(it) } }
            .map {
                it.insertSeparators { before: ListItem.LaunchItem?, after: ListItem.LaunchItem? ->
                    when {
                        after == null -> null
                        before == null -> ListItem.Separator(after.launch.launchYear)
                        before.launch.launchYear < after.launch.launchYear -> ListItem.Separator(
                            after.launch.launchYear
                        )
                        else -> null
                    }
                }
            }
            .cachedIn(viewModelScope)
    }
}