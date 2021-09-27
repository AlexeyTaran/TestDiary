package com.taran.testdiary.data.repository

import com.taran.testdiary.data.db.AppDatabase
import com.taran.testdiary.data.db.model.MemberDb
import com.taran.testdiary.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(private val appDatabase: AppDatabase) : MemberRepository {
    override fun getMemberList(): Flow<List<MemberDb>> {
        return appDatabase.memberDao().getAllMembers()
    }

    override fun getMemberById(id: Int): MemberDb? {
        return appDatabase.memberDao().getMemberById(id)
    }
}