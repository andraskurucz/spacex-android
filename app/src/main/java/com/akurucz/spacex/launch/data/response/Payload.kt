package com.akurucz.spacex.launch.data.response

data class Payload(
    val customers: List<String>,
    val manufacturer: String,
    val nationality: String,
    val norad_id: List<Int>,
    val orbit: String,
    val orbit_params: OrbitParams,
    val payload_id: String,
    val payload_mass_kg: Any,
    val payload_mass_lbs: Any,
    val payload_type: String,
    val reused: Boolean
)