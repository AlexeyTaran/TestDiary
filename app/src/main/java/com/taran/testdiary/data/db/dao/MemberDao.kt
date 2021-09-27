package com.taran.testdiary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.taran.testdiary.data.db.model.MemberDb
import kotlinx.coroutines.flow.Flow

@Dao
interface MemberDao {

    @Query("SELECT * FROM Member")
    fun getAllMembers(): Flow<List<MemberDb>>

    @Query("SELECT * FROM Member WHERE id = :memberId")
    fun getMemberById(memberId: Int): MemberDb?

    @Insert
    fun insertNewMember(member: MemberDb)
}