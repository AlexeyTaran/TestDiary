package com.taran.testdiary.domain.model

import com.taran.testdiary.data.db.model.MemberDb
import java.util.*

data class Member(
    val id: Int,
    val weight: Int,
    val dateOfBirth: Calendar
)

fun MemberDb.toDomainMember(): Member {
    return Member(id, weight, dateOfBirth)
}