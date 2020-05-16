package com.akurucz.spacex.launch.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akurucz.spacex.R
import com.akurucz.spacex.launch.model.Launch
import kotlinx.android.synthetic.main.launch_item.view.*

class LaunchViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(launch: Launch, onItemClicked: (Launch) -> Unit) {
        view.item_number.text = launch.missionName
        view.content.text = launch.rocketName
        view.setOnClickListener { onItemClicked(launch) }
    }

    companion object {
        fun create(parent: ViewGroup): LaunchViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.launch_item, parent, false)
            return LaunchViewHolder(view)
        }
    }
}