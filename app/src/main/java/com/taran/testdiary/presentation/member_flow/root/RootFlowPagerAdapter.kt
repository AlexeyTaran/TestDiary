package com.taran.testdiary.presentation.member_flow.root

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.taran.testdiary.presentation.member_flow.dob.DobFlowFragment
import com.taran.testdiary.presentation.member_flow.photo.PhotoFlowFragment
import com.taran.testdiary.presentation.member_flow.weight.WeightFlowFragment

class RootFlowPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WeightFlowFragment()
            1 -> DobFlowFragment()
            2 -> PhotoFlowFragment()
            else -> throw IllegalStateException("Unknown fragment")
        }
    }
}
private const val FRAGMENT_COUNT = 3