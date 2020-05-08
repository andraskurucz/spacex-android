package com.akurucz.spacex.launch.data.response

data class OrbitParams(
    val apoapsis_km: Double?,
    val arg_of_pericenter: Double?,
    val eccentricity: Double?,
    val epoch: String?,
    val inclination_deg: Any,
    val lifespan_years: Int?,
    val longitude: Any,
    val mean_anomaly: Any,
    val mean_motion: Any,
    val periapsis_km: Any,
    val period_min: Any,
    val raan: Any,
    val reference_system: String,
    val regime: String,
    val semi_major_axis_km: Any
)