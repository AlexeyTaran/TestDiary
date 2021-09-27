package com.taran.testdiary.di

import android.content.Context
import androidx.room.Room
import com.taran.testdiary.common.Constants
import com.taran.testdiary.data.db.AppDatabase
import com.taran.testdiary.data.repository.MemberRepositoryImpl
import com.taran.testdiary.domain.repository.MemberRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, Constants.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideMemberRepository(appDatabase: AppDatabase): MemberRepository {
        return MemberRepositoryImpl(appDatabase)
    }
}