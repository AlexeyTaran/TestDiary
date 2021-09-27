package com.taran.testdiary.presentation.member_list

import com.taran.testdiary.domain.model.Member

data class MemberListState(
    val isLoading: Boolean = false,
    val memberList: List<Member> = emptyList(),
    val error: String = ""
)
