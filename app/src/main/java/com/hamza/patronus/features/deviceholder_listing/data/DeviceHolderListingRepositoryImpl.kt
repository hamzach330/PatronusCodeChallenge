package com.hamza.patronus.features.deviceholder_listing.data

import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_listing.data.remote.DeviceHolderListingApi
import com.hamza.patronus.features.deviceholder_listing.domain.model.Customers
import com.hamza.patronus.features.deviceholder_listing.domain.model.DeviceHolderItem
import com.hamza.patronus.features.deviceholder_listing.domain.repository.DeviceHolderListingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeviceHolderListingRepositoryImpl @Inject constructor(
    private val remoteApi: DeviceHolderListingApi
) : DeviceHolderListingRepository {

//    override suspend fun getDeviceHolderListing(): Flow<Resource<List<DeviceHolderItem>>> = flow {
//        emit(Resource.Loading<List<DeviceHolderItem>>())
//        kotlinx.coroutines.delay(2000)
//        kotlin.runCatching {
//            remoteApi.getDeviceHolderListing()
//        }.onSuccess {
//            emit(Resource.Success(it))
//        }.onFailure {
//            emit(Resource.Error<List<DeviceHolderItem>>(it.localizedMessage))
//        }
//    }


    override suspend fun getDeviceHolderListing(): Flow<Resource<Customers>> = flow {
        emit(Resource.Loading<Customers>())
        kotlinx.coroutines.delay(2000)
        kotlin.runCatching {
            remoteApi.getDeviceHolderListing()
        }.onSuccess {
            emit(Resource.Success(it))
        }.onFailure {
            emit(Resource.Error<Customers>(it.localizedMessage))
        }
    }

}