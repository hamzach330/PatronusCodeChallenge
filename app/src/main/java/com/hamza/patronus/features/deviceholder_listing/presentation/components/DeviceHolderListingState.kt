package com.hamza.patronus.features.deviceholder_listing.presentation.components

import com.hamza.patronus.features.deviceholder_listing.domain.model.DeviceHolder


data class DeviceHolderListingState(
    val deviceHolderListItems: List<DeviceHolder> = emptyList(),
    val isLoading: Boolean = false
)