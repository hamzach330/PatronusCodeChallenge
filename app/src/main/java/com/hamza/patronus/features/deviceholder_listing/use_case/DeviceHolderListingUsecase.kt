package com.hamza.patronus.features.deviceholder_listing.use_case

import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_listing.domain.model.Customers
import com.hamza.patronus.features.deviceholder_listing.domain.repository.DeviceHolderListingRepository
import kotlinx.coroutines.flow.Flow

class DeviceHolderListingUsecase(
    private val repository: DeviceHolderListingRepository
) {

//    operator suspend fun invoke():  Flow<Resource<List<DeviceHolderItem>>> {
//        return repository.getDeviceHolderListing()
//    }

    operator suspend fun invoke():  Flow<Resource<Customers>> {
        return repository.getDeviceHolderListing()
    }
}