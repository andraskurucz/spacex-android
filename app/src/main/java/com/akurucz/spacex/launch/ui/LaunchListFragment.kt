package com.akurucz.spacex.launch.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.navigation.fragment.findNavController
import com.akurucz.spacex.App
import com.akurucz.spacex.R
import com.akurucz.spacex.launch.model.Launch
import kotlinx.android.synthetic.main.fragment_launch_list.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class LaunchListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: LaunchViewModelFactory
    private lateinit var viewModel: LaunchViewModel

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

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LaunchRecyclerViewAdapter(::onItemClicked)
        view.list.adapter = adapter
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        view.list.addItemDecoration(decoration)

        viewModel = viewModelFactory.create(LaunchViewModel::class.java)

        lifecycleScope.launch {
            viewModel.getStream().collect {
                adapter.presentData(it)
            }
        }
    }

    private fun onItemClicked(item: Launch) {
        findNavController().navigate(
            LaunchListFragmentDirections.actionLaunchListFragmentToLaunchDetailFragment(
                item
            )
        )
    }
}
