package com.taran.testdiary.presentation.member_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.taran.testdiary.R
import com.taran.testdiary.databinding.FragmentListMemberBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MemberListFragment : Fragment(R.layout.fragment_list_member) {
    private val viewModel: MemberListViewModel by viewModels()
    private val viewBinding: FragmentListMemberBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupData()
    }

    private fun setupView() {
        with (viewBinding) {
            toFlowButton.setOnClickListener {
                findNavController().navigate(MemberListFragmentDirections.actionMemberListFragmentToRootFlowFragment())
            }
        }
    }

    private fun setupData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.memberList.collect {
                    Log.d("ttt", "List = $it")
                }
            }
        }
    }
}