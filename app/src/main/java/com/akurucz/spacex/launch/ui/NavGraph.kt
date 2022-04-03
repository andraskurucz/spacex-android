package com.akurucz.spacex.launch.ui

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.akurucz.spacex.launch.model.Launch
import com.akurucz.spacex.launch.ui.Destinations.LaunchDetails
import com.squareup.moshi.Moshi

object Destinations {
    const val LaunchList = "launchList"
    const val LaunchDetails = "launchDetails"

    object LaunchDetailsArgs {
        const val launch = "launch"
    }
}

private val launchJsonAdapter by lazy { Moshi.Builder().build().adapter(Launch::class.java) }

class Actions(navHostController: NavHostController) {
    val openLaunchDetails: (Launch) -> Unit = { launch ->

        val launchUri = Uri.encode(launchJsonAdapter.toJson(launch))
        navHostController.navigate("$LaunchDetails/$launchUri")
    }

    val navigateBack: () -> Unit = {
        navHostController.navigateUp()
    }
}

class LaunchParamType : NavType<Launch>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Launch? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Launch {
        return launchJsonAdapter.fromJson(value)!!
    }

    override fun put(bundle: Bundle, key: String, value: Launch) {
        bundle.putParcelable(key, value)
    }
}