package com.akurucz.spacex.launch.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akurucz.spacex.launch.model.Launch
import com.akurucz.spacex.launch.ui.Destinations.LaunchDetails
import com.akurucz.spacex.launch.ui.Destinations.LaunchList

@Composable
fun SpaceXApp(viewModel: LaunchViewModel) {

    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController = navController, startDestination = LaunchList) {
        composable(LaunchList) {
            LaunchListScreen(
                viewModel = viewModel,
                openLaunchDetails = actions.openLaunchDetails
            )
        }
        composable(
            "$LaunchDetails/{${Destinations.LaunchDetailsArgs.launch}}",
            arguments = listOf(
                navArgument(Destinations.LaunchDetailsArgs.launch) {
                    type = LaunchParamType()
                }
            )
        ) {
            val launch = it.arguments?.getParcelable<Launch>(Destinations.LaunchDetailsArgs.launch)
                ?: return@composable
            LaunchDetailsScreen(
                launch = launch,
                viewModel = viewModel,
                navigateBack = actions.navigateBack
            )
        }
    }
}