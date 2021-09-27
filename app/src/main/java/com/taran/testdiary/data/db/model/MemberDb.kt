package com.taran.testdiary.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taran.testdiary.common.Constants
import com.taran.testdiary.domain.model.Member
import java.util.*

@Entity(tableName = Constants.TABLE_NAME_MEMBER)
data class MemberDb(
    val weight: Int, // in kg for now
    val dateOfBirth: Calendar
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}