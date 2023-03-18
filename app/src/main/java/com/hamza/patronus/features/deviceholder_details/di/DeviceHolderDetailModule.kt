package com.hamza.patronus.features.deviceholder_details.di

import com.hamza.doctorboxtest.features.user_details.data.remote.DeviceHolderDetailsApi
import com.hamza.patronus.features.deviceholder_details.data.DeviceHolderDetailRepositoryImpl
import com.hamza.patronus.features.deviceholder_details.domain.model.DeviceHolderDetail
import com.hamza.patronus.features.deviceholder_details.domain.repository.DeviceHolderDetailRepository
import com.hamza.patronus.features.deviceholder_details.use_case.DeviceHolderDetailUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DeviceHolderDetailModule {

    @Provides
    @Singleton
    fun provideUserDetailsApi(retrofit: Retrofit): DeviceHolderDetailsApi {
        return retrofit.create(DeviceHolderDetailsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserDetailsRepo(api: DeviceHolderDetailsApi): DeviceHolderDetailRepository {
        return DeviceHolderDetailRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providerUserDetailsUsecase(repo: DeviceHolderDetailRepository): DeviceHolderDetailUsecase {
        return DeviceHolderDetailUsecase(repo)
    }

}