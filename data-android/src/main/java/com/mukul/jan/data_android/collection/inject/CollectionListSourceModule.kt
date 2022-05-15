package com.mukul.jan.data_android.collection.inject


import com.mukul.jan.data.collection.source.CollectionListDataSource
import com.mukul.jan.data.collection.source.CollectionListRepository
import com.mukul.jan.data_android.collection.source.CollectionListDataSourceImpl
import com.mukul.jan.data_android.collection.source.CollectionListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CollectionListSourceModule {

    @Binds
    abstract fun bindCollectionListDataSource(collectionListDataSourceImpl: CollectionListDataSourceImpl) : CollectionListDataSource

    @Binds
    abstract fun bindCollectionListRepository(collectionListRepositoryImpl: CollectionListRepositoryImpl) : CollectionListRepository


}