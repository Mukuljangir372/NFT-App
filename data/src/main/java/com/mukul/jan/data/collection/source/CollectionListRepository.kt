package com.mukul.jan.data.collection.source

import androidx.paging.PagingData
import com.mukul.jan.data.collection.local.Collection
import kotlinx.coroutines.flow.Flow

interface CollectionListRepository {
    suspend fun getCollections() : Flow<PagingData<Collection>>
}