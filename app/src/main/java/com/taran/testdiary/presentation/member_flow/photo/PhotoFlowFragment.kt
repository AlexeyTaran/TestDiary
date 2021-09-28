package com.taran.testdiary.presentation.member_flow.photo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.taran.testdiary.R
import com.taran.testdiary.databinding.FragmentPhotoFlowBinding
import com.taran.testdiary.presentation.member_flow.root.RootFlowViewModel

class PhotoFlowFragment : Fragment(R.layout.fragment_photo_flow) {
    private val rootViewModel: RootFlowViewModel by viewModels(ownerProducer = { requireParentFragment() })
    private val viewBinding: FragmentPhotoFlowBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        with (viewBinding) {
            footer.back.setOnClickListener {
                rootViewModel.toDateOfBirth()
            }
            footer.next.setOnClickListener {
                rootViewModel.setPhoto("")
            }
        }
    }
}