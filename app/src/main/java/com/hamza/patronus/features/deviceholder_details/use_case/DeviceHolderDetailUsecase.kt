package com.hamza.patronus.features.deviceholder_details.use_case

import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail
import com.hamza.patronus.features.deviceholder_details.domain.repository.DeviceHolderDetailRepository
import kotlinx.coroutines.flow.Flow

class DeviceHolderDetailUsecase(
    private val repository: DeviceHolderDetailRepository
) {

    operator suspend fun invoke(userId: String): Flow<Resource<DeviceHolderDetail>> {
        return repository.getDeviceHolderDetail(userId)
    }
}