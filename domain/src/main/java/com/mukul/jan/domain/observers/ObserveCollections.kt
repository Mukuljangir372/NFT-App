package com.mukul.jan.domain.observers

import androidx.paging.PagingData
import com.mukul.jan.data.collection.local.Collection
import com.mukul.jan.data.collection.source.CollectionListRepository
import com.mukul.jan.domain.ObserverInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveCollections @Inject constructor(
    private val collectionListRepository: CollectionListRepository
) : ObserverInteractor<ObserveCollections.Params, PagingData<Collection>>() {
    override suspend fun createObservable(params: Params): Flow<PagingData<Collection>> {
        return collectionListRepository.getCollections()
    }
    data class Params(val id: Int? = null)
}