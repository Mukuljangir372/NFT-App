package com.mukul.jan.data_android.collection.inject

import com.mukul.jan.data.collection.mapper.CollectionDataMapper
import com.mukul.jan.data.collection.network.CollectionListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CollectionListModule {

    @Singleton
    @Provides
    fun collectionListApi(retrofit: Retrofit): CollectionListApi {
        return retrofit.create(CollectionListApi::class.java)
    }

    @Singleton
    @Provides
    fun collectionDataMapper() : CollectionDataMapper{
        return Mappers.getMapper(CollectionDataMapper::class.java)
    }

}