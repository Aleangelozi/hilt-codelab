package com.aleangelozi.hiltcodelab.hilt

import com.aleangelozi.hiltcodelab.network.MyAppNetworkAdapter
import com.aleangelozi.hiltcodelab.network.NetworkAdapter
import com.aleangelozi.hiltcodelab.network.NetworkService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    // @Binds
    // abstract fun bindNetworkAdapterImpl(networkAdapterImpl: MyAppNetworkAdapter): NetworkAdapter

    @Provides
    fun provideNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .build()
    }
}