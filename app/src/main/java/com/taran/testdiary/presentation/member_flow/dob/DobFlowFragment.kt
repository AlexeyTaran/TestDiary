package com.taran.testdiary.presentation.member_flow.dob

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.taran.testdiary.R
import com.taran.testdiary.databinding.FragmentDobFlowBinding
import com.taran.testdiary.presentation.member_flow.root.RootFlowViewModel
import java.util.*

class DobFlowFragment : Fragment(R.layout.fragment_dob_flow) {
    private val viewBinding: FragmentDobFlowBinding by viewBinding()
    private val rootViewModel: RootFlowViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        with(viewBinding) {
            calendar.maxDate = Calendar.getInstance().timeInMillis
            calendar.setOnDateChangeListener { calView: CalendarView, year: Int, month: Int, dayOfMonth: Int ->
                val calender: Calendar = Calendar.getInstance()
                calender.set(year, month, dayOfMonth)
                calView.setDate(calender.timeInMillis, true, true)
            }
            footer.next.setOnClickListener {
                rootViewModel.setMemberDateOfBirth(calendar.date)
                rootViewModel.toPhoto()
            }

            footer.back.setOnClickListener {
                rootViewModel.toWeight()
            }
        }
    }
}