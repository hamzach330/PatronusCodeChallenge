package com.hamza.patronus.features.deviceholder_listing.domain.repository

import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_listing.domain.model.Customers
import com.hamza.patronus.features.deviceholder_listing.domain.model.DeviceHolderItem
import kotlinx.coroutines.flow.Flow

interface DeviceHolderListingRepository {
    //suspend fun getDeviceHolderListing(): Flow<Resource<List<DeviceHolderItem>>>
    suspend fun getDeviceHolderListing(): Flow<Resource<Customers>>

}