package com.taran.testdiary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.taran.testdiary.common.Constants
import com.taran.testdiary.data.db.converter.CalendarConverter
import com.taran.testdiary.data.db.dao.MemberDao
import com.taran.testdiary.data.db.model.MemberDb

@Database(entities = [MemberDb::class], version = Constants.DATABASE_VERSION)
@TypeConverters(CalendarConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memberDao(): MemberDao
}