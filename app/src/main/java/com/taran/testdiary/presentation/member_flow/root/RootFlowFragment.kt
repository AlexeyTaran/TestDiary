package com.taran.testdiary.presentation.member_flow.root

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.taran.testdiary.R
import com.taran.testdiary.databinding.FragmentRootFlowBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RootFlowFragment : Fragment(R.layout.fragment_root_flow) {

    private val viewBinding: FragmentRootFlowBinding by viewBinding()
    private val viewModel: RootFlowViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupData()
    }

    private fun setupView() {
        with(viewBinding) {
            viewPager.isUserInputEnabled = false
            viewPager.adapter =
                RootFlowPagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)

            activity?.onBackPressedDispatcher?.addCallback(owner = this@RootFlowFragment) {
                if (viewPager.currentItem != 0) {
                    viewPager.currentItem = viewPager.currentItem - 1
                } else {
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun setupData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.currentFlowPosition.collect { position ->
                        viewBinding.viewPager.currentItem = position
                    }
                }
                launch {
                    viewModel.moveBack.collect {
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }
}