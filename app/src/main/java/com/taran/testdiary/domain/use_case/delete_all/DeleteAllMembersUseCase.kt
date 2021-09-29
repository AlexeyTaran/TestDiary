package com.taran.testdiary.domain.use_case.delete_all

import com.taran.testdiary.common.Result
import com.taran.testdiary.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteAllMembersUseCase @Inject constructor(private val memberRepository: MemberRepository) {
    operator fun invoke(): Flow<Result<Unit>> {
        return flow {
            emit(Result.Loading())
            memberRepository.deleteAllMembers()
            emit(Result.Success(Unit))
        }
    }
}