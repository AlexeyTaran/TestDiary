package com.taran.testdiary.domain.repository

import com.taran.testdiary.data.db.model.MemberDb
import kotlinx.coroutines.flow.Flow

interface MemberRepository {
    fun getMemberById(id: Int): MemberDb?
    fun getMemberList(): Flow<List<MemberDb>>
}