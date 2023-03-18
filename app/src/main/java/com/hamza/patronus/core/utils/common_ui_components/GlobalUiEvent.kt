package com.hamza.patronus.core.utils.common_ui_components

sealed class GlobalUiEvent {
    data class ShowSnackbar(val message: String) : GlobalUiEvent()
}