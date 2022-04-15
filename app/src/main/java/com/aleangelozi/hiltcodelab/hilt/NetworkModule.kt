package com.aleangelozi.hiltcodelab.hilt

import com.aleangelozi.hiltcodelab.network.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
//@InstallIn(ActivityComponent::class, ViewComponent::class)
@InstallIn(ActivityComponent::class)
class NetworkModule {

    // @Binds
    // abstract fun bindNetworkAdapterImpl(networkAdapterImpl: MyAppNetworkAdapter): NetworkAdapter

    /*@Provides
    fun provideNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .build()
    }*/

    @ActivityScoped // It ensures that only one instance is created on this scope
    @CallInterceptor
    @Provides
    fun provideCallNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .interceptor(CallInterceptorImpl())
            .build()
    }

    @ActivityScoped
    @ResponseInterceptor
    @Provides
    fun provideResponseNetworkService() : NetworkService {
        return NetworkService.Builder()
            .host("google.com")
            .protocol("HTTPS")
            .interceptor(ResponseInterceptorImpl())
            .build()
    }
}