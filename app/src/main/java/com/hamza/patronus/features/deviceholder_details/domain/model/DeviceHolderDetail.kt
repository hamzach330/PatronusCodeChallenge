package com.hamza.patronus.features.deviceholder_details.domain.model

data class DeviceHolderDetail(
    val id: Int?,
    val imageUrl: String,
    val currentLatitude: Double,
    val currentLongitude: Double,
    val firstName: String,
    val lastName: String,
    val stickers: ArrayList<String>,
    val gender: String,
    val phoneNumber: String,
    val address: Address,
)

data class Address(
    val street: String,
    val city: String,
    val state: String,
    val zip: String,
    val country: String
)


