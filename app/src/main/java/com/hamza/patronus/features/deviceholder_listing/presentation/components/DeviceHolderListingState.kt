package com.hamza.patronus.features.deviceholder_listing.presentation.components

import com.hamza.patronus.features.deviceholder_listing.domain.model.DeviceHolderItem


data class DeviceHolderListingState(
    val deviceHolderListItems: List<DeviceHolderItem> = emptyList(),
    val isLoading: Boolean = false
)