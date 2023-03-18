package com.hamza.patronus.features.deviceholder_listing.domain.model

import com.google.gson.annotations.SerializedName


data class Customers(
    @SerializedName("customers")
    val deviceHolderList: List<DeviceHolder>
)


data class DeviceHolder(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val phoneNumber: String,
    val imageUrl: String,
    val stickers: List<String>
)

