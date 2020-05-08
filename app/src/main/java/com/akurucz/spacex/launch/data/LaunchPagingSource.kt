package com.akurucz.spacex.launch.data

import androidx.paging.PagingSource
import com.akurucz.spacex.launch.model.Launch
import java.lang.Exception
import javax.inject.Inject

class LaunchPagingSource @Inject constructor(private val service: SpaceXService) :
    PagingSource<Int, Launch>() {

    companion object {
        private const val START_PAGE_INDEX = 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Launch> {
        val currentPage = params.key ?: START_PAGE_INDEX
        val offset = currentPage * params.pageSize

        return try {
            val launches = service.getLaunches(limit = params.loadSize, offset = offset).map {
                Launch(missionName = it.mission_name, rocketName = it.rocket.rocket_name)
            }

            LoadResult.Page(
                data = launches,
                prevKey = if (currentPage == START_PAGE_INDEX) null else currentPage - 1,
                // if we don't get any results, we consider that we're at the last page
                nextKey = if (launches.isEmpty()) null else currentPage + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}