package com.githukudenis.dialogsdemo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class MainUiState(
    val isDialogVisible: Boolean = false
)

class SignInViewModel: ViewModel() {

    // property holding class state
    private var _state: MutableState<MainUiState> = mutableStateOf(MainUiState())
    val state: State<MainUiState> = _state


    // method triggers change in state (action)
    fun toggleDialog(isVisible: Boolean) {
        _state.value = _state.value.copy(
            isDialogVisible = isVisible
        )
    }
}