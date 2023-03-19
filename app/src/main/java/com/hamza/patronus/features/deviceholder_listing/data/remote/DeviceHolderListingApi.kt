package com.hamza.patronus.features.deviceholder_listing.data.remote

import com.hamza.patronus.features.deviceholder_listing.domain.model.Customers
import retrofit2.http.GET

interface DeviceHolderListingApi {

    @GET("users")
    suspend fun getDeviceHolderListing(): Customers
}