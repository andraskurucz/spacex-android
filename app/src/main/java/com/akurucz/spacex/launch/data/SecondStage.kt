package com.akurucz.spacex.launch.data

data class SecondStage(
    val block: Int?,
    val payloads: List<Payload>
)