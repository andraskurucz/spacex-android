package com.akurucz.spacex.launch.data

data class LaunchFailureDetails(
    val altitude: Int?,
    val reason: String,
    val time: Int
)