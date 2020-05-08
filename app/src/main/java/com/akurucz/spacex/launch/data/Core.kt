package com.akurucz.spacex.launch.data

data class Core(
    val block: Int?,
    val core_serial: String?,
    val flight: Int?,
    val gridfins: Boolean?,
    val land_success: Boolean?,
    val landing_intent: Boolean?,
    val landing_type: String?,
    val landing_vehicle: String?,
    val legs: Boolean?,
    val reused: Boolean
)