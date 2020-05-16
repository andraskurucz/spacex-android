package com.akurucz.spacex.launch.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Launch(val missionName: String, val rocketName: String) : Parcelable