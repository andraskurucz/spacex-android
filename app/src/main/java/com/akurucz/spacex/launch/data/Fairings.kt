package com.akurucz.spacex.launch.data

data class Fairings(
    val recovered: Boolean?,
    val recovery_attempt: Boolean?,
    val reused: Boolean?,
    val ship: String?
)