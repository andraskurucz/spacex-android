package com.akurucz.spacex.launch.data

import com.squareup.moshi.Json

data class Timeline(
    val beco: Int,
    val center_core_entry_burn: Int,
    val center_core_landing: Int,
    val center_stage_sep: Int,
    val engine_chill: Int,
    val fairing_deploy: Int,
    val go_for_launch: Int,
    val go_for_prop_loading: Int,
    val ignition: Int,
    val liftoff: Int,
    val maxq: Int,
    val meco: Int,
    val payload_deploy: Int,
    val prelaunch_checks: Int,
    val propellant_pressurization: Int,
    @Json(name = "seco-1") val seco1: Int,
    @Json(name = "seco-2") val seco2: Int,
    @Json(name = "seco-3") val seco3: Int,
    @Json(name = "seco-4") val seco4: Int,
    val second_stage_ignition: Int,
    val second_stage_restart: Int,
    val side_core_boostback: Int,
    val side_core_entry_burn: Int,
    val side_core_landing: Int,
    val side_core_sep: Int,
    val stage1_lox_loading: Int,
    val stage1_rp1_loading: Int,
    val stage2_lox_loading: Int,
    val stage2_rp1_loading: Int,
    val webcast_liftoff: Int?
)