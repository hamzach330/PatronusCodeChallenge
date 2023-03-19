package com.hamza.patronus.features.deviceholder_listing.domain.model

import com.google.gson.annotations.SerializedName


class CustomersFactory(
    val deviceHolderListFactory: List<DeviceHolderListFactory>
)


class DeviceHolderListFactory {

    val ITEM_1 = DeviceHolder(
        firstName = "Emily",
        gender = "FEMALE",
        id = 0,
        imageUrl = "https://fastly.picsum.photos/id/628/400/400.jpg?hmac=uQnrWHhKS3XBUnJaTHJHb7TBhQX7uZ0p1q_Y2hLnEWY",
        lastName = "Brown",
        phoneNumber = "123-456-7895",
        stickers = listOf("Fam","Bam")
    )

    val ITEM_2 = DeviceHolder(
        firstName = "hamza ",
        gender = "Male",
        id = 0,
        imageUrl = "https://fastly.picsum.photos/id/650/400/400.jpg?hmac=aRSRZFa8j3OPfCyAkMVThCXyRqSK-GhyPHmkcZscOC8",
        lastName = "Masood",
        phoneNumber = "321321321",
        stickers = listOf("Fam","Bam")
    )

    val ITEM_3 = DeviceHolder(
        firstName = "Zuabare",
        gender = "Male",
        id = 0,
        imageUrl = "null",
        lastName = "haq",
        phoneNumber = "321384",
        stickers = listOf("Fam","Bam")
    )

    val ITEM_4 = DeviceHolder(
        firstName = "ALi",
        gender = "Malew",
        id = 0,
        imageUrl = "https://example.com/sophia.jpg",
        lastName = "Malang",
        phoneNumber = "32132155321",
        stickers = listOf("Fam","Bam")
    )

}