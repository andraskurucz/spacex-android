package com.akurucz.spacex.launch.data

import com.akurucz.spacex.launch.model.Launch
import com.akurucz.spacex.launch.model.LaunchRepository
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val service: SpaceXService
) : LaunchRepository {

    override suspend fun getLaunches(): List<Launch> =
        service.getLaunches(limit = 10, offset = 0).map {
            Launch(missionName = it.mission_name, rocketName = it.rocket.rocket_name)
        }
}