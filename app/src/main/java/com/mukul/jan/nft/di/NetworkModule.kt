package com.mukul.jan.nft.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mukul.jan.core_android.network.DateDeserializer
import com.mukul.jan.nft.BuildConfig
import com.mukul.jan.nft.util.NetworkUtils.APP_CACHE_DIR
import com.mukul.jan.nft.util.NetworkUtils.OKHTTP_CACHE_SIZE
import com.mukul.jan.nft.util.NetworkUtils.OPENSEA_KEY
import com.mukul.jan.nft.util.NetworkUtils.OPENSEA_URL
import com.mukul.jan.nft.util.NetworkUtils.RETROFIT_GSON
import com.mukul.jan.nft.util.NetworkUtils.X_API_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named(APP_CACHE_DIR)
    fun cacheDir(@ApplicationContext context: Context): File = context.cacheDir

    @Provides
    @Named(OPENSEA_URL)
    fun openseaBaseUrl(): String = BuildConfig.OPENSEA_BASE_URL

    @Provides
    @Named(OPENSEA_KEY)
    fun openseaKey(): String = BuildConfig.OPENSEA_API_KEY

    @Provides
    @Named(RETROFIT_GSON)
    fun gson() : Gson {
        return GsonBuilder()
            .registerTypeAdapter(Date::class.java,DateDeserializer())
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        @Named(RETROFIT_GSON) gson: Gson,
        @Named(OPENSEA_URL) openseaUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(openseaUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun okHttpClient(
        @Named(OPENSEA_KEY) openseaKey: String,
        @Named(APP_CACHE_DIR) cacheDir: File,
    ): OkHttpClient {
        val httpLogging = HttpLoggingInterceptor()
        httpLogging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val cache = Cache(cacheDir, OKHTTP_CACHE_SIZE)
        return OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val request = chain.request()
                val newRequest = request.newBuilder()
                    .addHeader(X_API_KEY, openseaKey)
                    .build()
                chain.proceed(newRequest)
            })
            .addInterceptor(httpLogging)
            .cache(cache = cache)
            .build()
    }


}







