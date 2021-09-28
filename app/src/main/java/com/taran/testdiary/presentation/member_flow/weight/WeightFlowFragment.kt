package com.taran.testdiary.presentation.member_flow.weight

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.taran.testdiary.R
import com.taran.testdiary.databinding.FragmentWeightFlowBinding
import com.taran.testdiary.presentation.member_flow.root.RootFlowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeightFlowFragment : Fragment(R.layout.fragment_weight_flow) {
    private val rootViewModel: RootFlowViewModel by viewModels(ownerProducer = { requireParentFragment() })
    private val viewBinding: FragmentWeightFlowBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        with(viewBinding) {
            footer.back.setOnClickListener { findNavController().popBackStack() } // footer can be custom view
            weightEt.addTextChangedListener {
                footer.next.isEnabled = !it.isNullOrEmpty()
            }
            footer.next.setOnClickListener {
                val weight = try {
                    Integer.parseInt(weightEt.text?.toString() ?: "")
                } catch (e: NumberFormatException) {
                    0
                }
                if (weight > 0) {
                    rootViewModel.setMemberWeight(weight)
                    rootViewModel.toDateOfBirth()
                }
            }
        }
    }
}