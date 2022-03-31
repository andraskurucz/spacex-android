package com.akurucz.spacex.launch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.akurucz.spacex.App
import com.akurucz.spacex.databinding.FragmentLaunchListBinding
import com.akurucz.spacex.launch.model.Launch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class LaunchListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: LaunchViewModelFactory
    private lateinit var viewModel: LaunchViewModel
    private val adapter = LaunchRecyclerViewAdapter(::onItemClicked)
    private var _binding: FragmentLaunchListBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LaunchViewModel::class.java)

        lifecycleScope.launch {
            viewModel.launchesStream.collect {
                adapter.submitData(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLaunchListBinding.inflate(inflater, container, false)
            .also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoadStateAdapter { adapter.retry() },
            footer = LoadStateAdapter { adapter.retry() }
        )

        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.list.addItemDecoration(decoration)
    }

    private fun onItemClicked(item: Launch) {
        findNavController().navigate(
            LaunchListFragmentDirections.actionLaunchListFragmentToLaunchDetailFragment(
                item
            )
        )
    }
}
