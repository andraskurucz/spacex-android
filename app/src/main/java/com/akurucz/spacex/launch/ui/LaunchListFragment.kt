package com.akurucz.spacex.launch.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.akurucz.spacex.App
import com.akurucz.spacex.R
import com.akurucz.spacex.launch.model.Launch
import kotlinx.android.synthetic.main.fragment_launch_list.view.*
import javax.inject.Inject

class LaunchListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: LaunchViewModelFactory
    lateinit var viewModel: LaunchViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LaunchRecyclerViewAdapter(emptyList(), ::onItemClicked)
        view.list.adapter = adapter
        view.list.layoutManager = LinearLayoutManager(context)

        viewModel = viewModelFactory.create(LaunchViewModel::class.java)
        viewModel.launches.observe(viewLifecycleOwner, Observer {
            adapter.values = it
            adapter.notifyDataSetChanged()
        })
    }

    private fun onItemClicked(item: Launch) {
    }
}
