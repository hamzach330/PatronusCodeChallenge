package com.hamza.patronus.features.deviceholder_listing.di

import com.hamza.patronus.features.deviceholder_listing.data.DeviceHolderListingRepositoryImpl
import com.hamza.patronus.features.deviceholder_listing.data.remote.DeviceHolderListingApi
import com.hamza.patronus.features.deviceholder_listing.domain.repository.DeviceHolderListingRepository
import com.hamza.patronus.features.deviceholder_listing.use_case.DeviceHolderListingUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DeviceHolderListingModule {

    @Provides
    @Singleton
    fun provideUserListingApi(retrofit: Retrofit): DeviceHolderListingApi {
        return retrofit.create(DeviceHolderListingApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserListingRepo(api: DeviceHolderListingApi): DeviceHolderListingRepository {
        return DeviceHolderListingRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providerUserListingUsecase(repo: DeviceHolderListingRepository): DeviceHolderListingUsecase {
        return DeviceHolderListingUsecase(repo)
    }

}