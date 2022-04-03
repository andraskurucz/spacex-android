package com.akurucz.spacex.launch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akurucz.spacex.R
import com.akurucz.spacex.launch.model.Launch

@Composable
fun LaunchDetailsScreen(launch: Launch, viewModel: LaunchViewModel, navigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = launch.missionName) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.content_description_back)
                        )
                    }
                })
        }
    ) {
        LaunchDetails(launch = launch)
    }
}

@Composable
fun LaunchDetails(launch: Launch, modifier: Modifier = Modifier) {
    Surface {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = launch.rocketName)
            Text(text = launch.missionName)
            Text(text = launch.launchYear.toString())
        }
    }
}

@Preview
@Composable
fun LaunchDetailsPreview() {
    LaunchDetails(launch = generateRandomLaunch(), modifier = Modifier.fillMaxSize())
}
