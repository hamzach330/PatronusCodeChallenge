package com.hamza.patronus.features.deviceholder_details.presentation.components

import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail

data class DeviceHolderDetailState(
    val deviceHolderDetail: DeviceHolderDetail? = null,
    val isLoading: Boolean = false
)