package com.taran.testdiary.presentation.member_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taran.testdiary.common.Result
import com.taran.testdiary.domain.use_case.delete_all.DeleteAllMembersUseCase
import com.taran.testdiary.domain.use_case.get_members.GetMembersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberListViewModel @Inject constructor(
    private val getMembersUseCase: GetMembersUseCase,
    private val deleteAllMembersUseCase: DeleteAllMembersUseCase) : ViewModel() {
    private val _memberList = MutableStateFlow(MemberListState())
    val memberList: StateFlow<MemberListState> = _memberList

    init {
        loadMemberList()
    }

    private fun loadMemberList() {
        getMembersUseCase().onEach { result ->
            when (result) {
                is Result.Success -> {
                    _memberList.emit(MemberListState(memberList = result.data))
                }
                is Result.Error -> {
                    _memberList.emit(MemberListState(error = result.error))
                }
                is Result.Loading -> {
                    _memberList.emit(MemberListState(isLoading = true))
                }
            }
        }.launchIn(viewModelScope)
    }

    fun deleteAllMembers() {
        viewModelScope.launch {
            deleteAllMembersUseCase().onEach { result ->
                when (result) {
                    is Result.Success -> Log.i(TAG, "Removed all members")
                    else -> Log.i(TAG, "Removed all members with error")
                }
            }.launchIn(viewModelScope)
        }
    }
}
private const val TAG = "Member List"