package com.hamza.patronus.features.deviceholder_details.data.remote

import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DeviceHolderDetailsApi {


    @GET("users/{userId}")
    suspend fun getDeviceHolderDetail(@Path("userId") userId: String): DeviceHolderDetail?

}