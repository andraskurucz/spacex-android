package com.akurucz.spacex.launch.ui

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.akurucz.spacex.launch.model.Launch

class LaunchRecyclerViewAdapter(
    private val onItemClicked: (Launch) -> Unit
) : PagingDataAdapter<Launch, LaunchViewHolder>(LAUNCH_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        getItem(position)?.let(holder::bind)
    }

    companion object {
        private val LAUNCH_COMPARATOR = object : DiffUtil.ItemCallback<Launch>() {
            override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean =
                oldItem == newItem
        }
    }
}