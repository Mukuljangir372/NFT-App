package com.mukul.jan.domain.observers.inject

import com.mukul.jan.data.collection.source.CollectionListRepository
import com.mukul.jan.domain.observers.ObserveCollections
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ObserversModule {

    @Singleton
    @Provides
    fun observeCollections(collectionListRepository: CollectionListRepository) : ObserveCollections{
        return ObserveCollections(collectionListRepository)
    }

}