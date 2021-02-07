package com.akurucz.spacex.launch.ui

import com.akurucz.spacex.launch.model.Launch

sealed class ListItem {
    data class LaunchItem(val launch: Launch) : ListItem()
    data class Separator(val year: Int) : ListItem()
}