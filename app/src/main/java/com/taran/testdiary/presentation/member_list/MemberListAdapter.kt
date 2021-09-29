package com.taran.testdiary.presentation.member_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taran.testdiary.databinding.ItemMemberListBinding
import com.taran.testdiary.domain.model.Member
import java.text.SimpleDateFormat
import java.util.*

class MemberListAdapter : ListAdapter<Member, MemberListAdapter.MemberListViewHolder>(Member.DIFF_UTIL) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberListViewHolder {
        return MemberListViewHolder(ItemMemberListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MemberListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MemberListViewHolder(private val binding: ItemMemberListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(member: Member) {
            binding.weightValueTv.text = member.weight.toString() // do convert kg to lb
            binding.dobValueTv.text = dateOfBirthSimpleFormatter.format(member.dateOfBirth.time)
        }
    }
}
val dateOfBirthSimpleFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
