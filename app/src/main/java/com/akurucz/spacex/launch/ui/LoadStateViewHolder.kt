package com.akurucz.spacex.launch.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.akurucz.spacex.R
import kotlinx.android.synthetic.main.load_item.view.*

class LoadStateViewHolder(private val view: View, retry: () -> Unit) :
    RecyclerView.ViewHolder(view) {

    init {
        view.retry_button.setOnClickListener { retry() }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            view.error_msg.text = loadState.error.localizedMessage
        }
        view.progress_bar.visibility = toVisibility(loadState == LoadState.Loading)
        view.retry_button.visibility = toVisibility(loadState != LoadState.Loading)
        view.error_msg.visibility = toVisibility(loadState != LoadState.Loading)
    }

    private fun toVisibility(constraint: Boolean): Int = if (constraint) {
        View.VISIBLE
    } else {
        View.GONE
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): LoadStateViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.load_item, parent, false)
            return LoadStateViewHolder(view, retry)
        }
    }
}