package com.taran.testdiary.domain.model

import androidx.recyclerview.widget.DiffUtil
import com.taran.testdiary.data.db.model.MemberDb
import java.util.*

data class Member(
    val id: Int,
    val weight: Int,
    val dateOfBirth: Calendar
) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Member>() {
            override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
                return oldItem.weight == newItem.weight && oldItem.dateOfBirth == newItem.dateOfBirth
            }
        }
    }
}

fun MemberDb.toDomainMember(): Member {
    return Member(id, weight, dateOfBirth)
}