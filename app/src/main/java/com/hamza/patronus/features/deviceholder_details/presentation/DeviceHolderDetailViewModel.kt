package com.hamza.patronus.features.deviceholder_details.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.patronus.core.utils.common_ui_components.GlobalUiEvent
import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_details.presentation.components.DeviceHolderDetailState
import com.hamza.patronus.features.deviceholder_details.use_case.DeviceHolderDetailUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceHolderDetailViewModel @Inject constructor(
    private val usecase: DeviceHolderDetailUsecase
) : ViewModel() {

    private val _dataFlow = mutableStateOf(DeviceHolderDetailState())
    val dataFlow: State<DeviceHolderDetailState> = _dataFlow

    private val _eventFlow = MutableSharedFlow<GlobalUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun loadDeviceHolderDetails(userId: String) {
        viewModelScope.launch {
            val data = usecase.invoke(userId)
            data.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _dataFlow.value = dataFlow.value.copy(
                            deviceHolderDetail = null,
                            isLoading = true
                        )
                    }
                    is Resource.Success -> {
                        _dataFlow.value = dataFlow.value.copy(
                            deviceHolderDetail = result.data,
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _dataFlow.value = dataFlow.value.copy(
                            deviceHolderDetail = null,
                            isLoading = false
                        )
                        _eventFlow.emit(
                            GlobalUiEvent.ShowSnackbar(
                                result.message ?: "Unknown error"
                            )
                        )
                    }
                }
            }
        }
    }
}