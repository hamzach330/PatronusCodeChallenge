package com.hamza.patronus.features.deviceholder_details.domain.repository

import com.hamza.patronus.core.utils.json_parser.Resource
import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail
import kotlinx.coroutines.flow.Flow

interface DeviceHolderDetailRepository {
    suspend fun getDeviceHolderDetail(userId: String): Flow<Resource<DeviceHolderDetail>>
}