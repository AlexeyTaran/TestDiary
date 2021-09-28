package com.taran.testdiary.presentation.member_flow.root

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taran.testdiary.presentation.member_flow.root.model.FlowPart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootFlowViewModel @Inject constructor (private val savedState: SavedStateHandle) : ViewModel() {
    var weight: Int = savedState.get(WEIGHT_KEY) ?: 0  //in kg
        private set

    var dateOfBirth: Long = savedState.get(DOB_KEY) ?: 0L
        private set

    private val _currentFlowPosition = MutableStateFlow(FlowPart.WEIGHT.ordinal)
    val currentFlowPosition: StateFlow<Int> = _currentFlowPosition

    fun setMemberWeight(weight: Int) {
        this.weight = weight
        savedState[WEIGHT_KEY] = weight
    }

    fun setMemberDateOfBirth(timestamp: Long) {
        this.dateOfBirth = timestamp
        savedState[DOB_KEY] = timestamp
    }

    fun toDateOfBirth() {
        viewModelScope.launch {
            _currentFlowPosition.emit(FlowPart.DATE_OF_BIRTH.ordinal)
        }
    }

    fun toPhoto() {
        viewModelScope.launch {
            _currentFlowPosition.emit(FlowPart.PHOTO.ordinal)
        }
    }
}

private const val WEIGHT_KEY = "weight"
private const val DOB_KEY = "dob"