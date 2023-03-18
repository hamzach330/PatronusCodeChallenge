package com.hamza.patronus.features.deviceholder_details.data

import com.hamza.doctorboxtest.features.user_details.data.remote.DeviceHolderDetailsApi
import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail
import com.hamza.patronus.features.deviceholder_details.domain.repository.DeviceHolderDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeviceHolderDetailRepositoryImpl @Inject constructor(
    private val remoteApi: DeviceHolderDetailsApi
) : DeviceHolderDetailRepository {

    override suspend fun getDeviceHolderDetail(userId: String): Flow<Resource<DeviceHolderDetail>> =
        flow {
            emit(Resource.Loading())

            kotlin.runCatching {
                remoteApi.getDeviceHolderDetail(userId)
            }.onSuccess {
                emit(Resource.Success(it))
            }.onFailure {
                emit(Resource.Error<DeviceHolderDetail>(it.localizedMessage))
            }
        }
}