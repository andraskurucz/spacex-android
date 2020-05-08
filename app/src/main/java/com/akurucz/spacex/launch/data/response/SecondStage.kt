package com.akurucz.spacex.launch.data.response

data class SecondStage(
    val block: Int?,
    val payloads: List<Payload>
)