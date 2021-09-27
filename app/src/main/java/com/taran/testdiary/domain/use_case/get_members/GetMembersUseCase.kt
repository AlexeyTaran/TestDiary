package com.taran.testdiary.domain.use_case.get_members

import com.taran.testdiary.common.Result
import com.taran.testdiary.domain.model.Member
import com.taran.testdiary.domain.model.toDomainMember
import com.taran.testdiary.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMembersUseCase @Inject constructor(private val memberRepository: MemberRepository) {
    operator fun invoke(): Flow<Result<List<Member>>> {
        return flow {
            emit(Result.Loading<List<Member>>())
            emitAll(memberRepository.getMemberList().map { list ->
                Result.Success<List<Member>>(list.map { it.toDomainMember() })
            })
        }
    }
}