package com.akurucz.spacex.launch.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akurucz.spacex.databinding.LaunchItemBinding
import com.akurucz.spacex.launch.model.Launch

class LaunchViewHolder(private val binding: LaunchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(launch: Launch, onItemClicked: (Launch) -> Unit) {
        binding.itemNumber.text = launch.missionName
        binding.content.text = launch.rocketName
        binding.root.setOnClickListener { onItemClicked(launch) }
    }

    companion object {
        fun create(parent: ViewGroup): LaunchViewHolder {
            return LaunchViewHolder(
                LaunchItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}