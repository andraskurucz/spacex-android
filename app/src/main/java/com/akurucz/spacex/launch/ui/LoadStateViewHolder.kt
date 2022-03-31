package com.akurucz.spacex.launch.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.akurucz.spacex.databinding.LoadItemBinding

class LoadStateViewHolder(private val binding: LoadItemBinding, retry: () -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener { retry() }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.visibility = toVisibility(loadState == LoadState.Loading)
        binding.retryButton.visibility = toVisibility(loadState != LoadState.Loading)
        binding.errorMsg.visibility = toVisibility(loadState != LoadState.Loading)
    }

    private fun toVisibility(constraint: Boolean): Int = if (constraint) {
        View.VISIBLE
    } else {
        View.GONE
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): LoadStateViewHolder {
            return LoadStateViewHolder(
                binding = LoadItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                retry = retry
            )
        }
    }
}