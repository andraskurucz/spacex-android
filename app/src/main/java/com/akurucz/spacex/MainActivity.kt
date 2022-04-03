package com.akurucz.spacex

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.akurucz.spacex.launch.ui.LaunchListScreen
import com.akurucz.spacex.launch.ui.LaunchViewModel
import com.akurucz.spacex.launch.ui.SpaceXApp
import com.akurucz.spacex.launch.ui.SpaceXTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContent {
            SpaceXTheme {
                SpaceXApp(viewModel)
            }
        }
    }
}