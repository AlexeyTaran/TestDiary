package com.taran.testdiary.domain.use_case.insert_member

import com.taran.testdiary.common.Result
import com.taran.testdiary.data.db.model.MemberDb
import com.taran.testdiary.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class InsertMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    operator fun invoke(weight: Int, dateOfBirth: Long): Flow<Result<Unit>> {
        return flow {
            emit(Result.Loading())
            val memberDb = MemberDb(weight, Calendar.getInstance().apply { timeInMillis = dateOfBirth })
            memberRepository.insertNewMember(memberDb)
            emit(Result.Success(Unit))
        }
    }
}