package com.akurucz.spacex.launch.data

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingDataFlow
import com.akurucz.spacex.launch.model.Launch
import com.akurucz.spacex.launch.model.LaunchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val dataSource: LaunchPagingSource
) : LaunchRepository {

    companion object {
        private const val NETWORK_PAGE_SIZE = 3
    }

    override fun getLaunchStream(): Flow<PagingData<Launch>> {

        return PagingDataFlow(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { dataSource }
        )
    }
//        service.getLaunches(limit = 10, offset = 0).map {
//            Launch(missionName = it.mission_name, rocketName = it.rocket.rocket_name)
//        }
}