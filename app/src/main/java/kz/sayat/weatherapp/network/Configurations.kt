package kz.sayat.weatherapp.network

import kz.sayat.weatherapp.BuildConfig
import kz.sayat.weatherapp.network.responseConverterFactory.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Configurations {

    fun provideOkHttpClient() = OkHttpClient
        .Builder()
        .build()

    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()

    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}