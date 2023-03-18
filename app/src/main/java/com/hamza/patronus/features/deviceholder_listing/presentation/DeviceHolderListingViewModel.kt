package com.hamza.patronus.features.deviceholder_listing.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.patronus.core.utils.common_ui_components.GlobalUiEvent
import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_listing.presentation.components.DeviceHolderListingState
import com.hamza.patronus.features.deviceholder_listing.use_case.DeviceHolderListingUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceHolderListingViewModel @Inject constructor(
    private val deviceHolderListingUsecase: DeviceHolderListingUsecase
) : ViewModel() {

    private val _dataFlow = mutableStateOf(DeviceHolderListingState())
    val dataFlow: State<DeviceHolderListingState> = _dataFlow

    private val _eventFlow = MutableSharedFlow<GlobalUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            val data = deviceHolderListingUsecase.invoke()
            data.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _dataFlow.value = dataFlow.value.copy(
                            deviceHolderListItems = emptyList(),
                            isLoading = true
                        )
                    }
                    is Resource.Success -> {
                        _dataFlow.value = dataFlow.value.copy(
                            deviceHolderListItems = result.data?.deviceHolderList ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _dataFlow.value = dataFlow.value.copy(
                           deviceHolderListItems = emptyList(),
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