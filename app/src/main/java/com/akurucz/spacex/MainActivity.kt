package com.akurucz.spacex

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import com.akurucz.spacex.launch.ui.SpaceXTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContent {
            SpaceXTheme() {
                Text(text = "Hello Compose")
            }
        }
    }
}
