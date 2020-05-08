package com.akurucz.spacex.launch.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.akurucz.spacex.R
import com.akurucz.spacex.launch.model.Launch

import kotlinx.android.synthetic.main.launch_item.view.*

class LaunchRecyclerViewAdapter(
    var values: List<Launch>,
    private val onItemClicked: (Launch) -> Unit
) : RecyclerView.Adapter<LaunchRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.launch_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.mIdView.text = item.missionName
        holder.mContentView.text = item.rocketName

        with(holder.mView) {
            tag = item
            setOnClickListener {
                onItemClicked(values[position])
            }
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}