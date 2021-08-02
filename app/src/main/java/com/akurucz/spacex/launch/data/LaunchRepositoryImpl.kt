package com.akurucz.spacex.launch.data

import androidx.paging.Pager
import androidx.paging.PagingData
import com.akurucz.spacex.launch.model.Launch
import com.akurucz.spacex.launch.model.LaunchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val dataSource: LaunchPagingSource
) : LaunchRepository {

    override fun getLaunchStream(): Flow<PagingData<Launch>> {
        return Pager(
            config = LaunchPagingSource.config,
            pagingSourceFactory = { dataSource }
        ).flow
    }
}