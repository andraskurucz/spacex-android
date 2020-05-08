package com.akurucz.spacex.launch.data

import com.akurucz.spacex.launch.data.response.LaunchesResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceXService {

    @GET("/v3/launches")
    suspend fun getLaunches(@Query("limit") limit: Int, @Query("offset") offset: Int) : List<LaunchesResponseItem>
}