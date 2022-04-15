package com.aleangelozi.hiltcodelab.hilt

import com.aleangelozi.hiltcodelab.network.MyAppNetworkAdapter
import com.aleangelozi.hiltcodelab.network.NetworkAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindNetworkAdapterImpl(networkAdapterImpl: MyAppNetworkAdapter): NetworkAdapter
}