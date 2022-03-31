package com.akurucz.spacex.launch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.akurucz.spacex.databinding.FragmentLaunchDetailBinding

class LaunchDetailFragment : Fragment() {

    private val args: LaunchDetailFragmentArgs by navArgs()
    private var _binding: FragmentLaunchDetailBinding? = null
    private val binding: FragmentLaunchDetailBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLaunchDetailBinding.inflate(inflater, container, false)
            .also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.text = args.launch.missionName
    }
}