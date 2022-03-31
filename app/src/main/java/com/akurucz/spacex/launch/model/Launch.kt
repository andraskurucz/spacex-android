package com.akurucz.spacex.launch.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Launch(val missionName: String, val rocketName: String, val launchYear: Int) : Parcelable