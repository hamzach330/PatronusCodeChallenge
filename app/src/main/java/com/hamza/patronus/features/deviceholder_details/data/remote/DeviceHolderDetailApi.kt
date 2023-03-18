package com.hamza.doctorboxtest.features.user_details.data.remote

import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface DeviceHolderDetailsApi {

    @GET("users/{user_id}")
    suspend fun getDeviceHolderDetail(@Path("user_id") userId: String): DeviceHolderDetail?

}