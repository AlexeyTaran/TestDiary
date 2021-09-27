package com.taran.testdiary.domain.use_case.get_member

import com.taran.testdiary.common.Result
import com.taran.testdiary.data.db.model.MemberDb
import com.taran.testdiary.domain.model.Member
import com.taran.testdiary.domain.model.toDomainMember
import com.taran.testdiary.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMemberUseCase @Inject constructor(private val memberRepository: MemberRepository) {
    operator fun invoke(memberId: Int): Flow<Result<Member>> {
        return flow {
            emit(Result.Loading<Member>())
            val memberDb: MemberDb? = memberRepository.getMemberById(memberId)
            if (memberDb != null) {
                emit(Result.Success<Member>(memberDb.toDomainMember()))
            } else {
                emit(Result.Error<Member>("Can't find the member"))
            }
        }
    }
}