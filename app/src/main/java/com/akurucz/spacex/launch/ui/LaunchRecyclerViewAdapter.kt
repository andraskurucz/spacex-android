package com.akurucz.spacex.launch.ui

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akurucz.spacex.R
import com.akurucz.spacex.launch.model.Launch

class LaunchRecyclerViewAdapter(
    private val onItemClicked: (Launch) -> Unit
) : PagingDataAdapter<ListItem, RecyclerView.ViewHolder>(LAUNCH_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == R.layout.launch_item) LaunchViewHolder.create(parent)
        else SeparatorViewHolder.create(parent)
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is ListItem.LaunchItem -> R.layout.launch_item
            is ListItem.Separator -> R.layout.separator_item
            else -> throw UnsupportedOperationException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is ListItem.LaunchItem -> (holder as LaunchViewHolder).bind(item.launch, onItemClicked)
            is ListItem.Separator -> (holder as SeparatorViewHolder).bind(item.year)

        }
    }

    companion object {
        private val LAUNCH_COMPARATOR = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
                oldItem == newItem
        }
    }
}