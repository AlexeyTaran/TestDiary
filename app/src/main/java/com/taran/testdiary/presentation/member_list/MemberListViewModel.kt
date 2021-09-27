package com.taran.testdiary.presentation.member_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taran.testdiary.common.Result
import com.taran.testdiary.domain.use_case.get_members.GetMembersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MemberListViewModel @Inject constructor(private val getMembersUseCase: GetMembersUseCase)  : ViewModel() {
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
}