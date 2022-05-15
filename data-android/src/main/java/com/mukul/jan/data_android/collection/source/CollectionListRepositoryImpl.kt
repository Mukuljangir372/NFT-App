package com.mukul.jan.data_android.collection.source


import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mukul.jan.data.collection.local.Collection
import com.mukul.jan.data.collection.mapper.CollectionDataMapper
import com.mukul.jan.data.collection.source.CollectionListDataSource
import com.mukul.jan.data.collection.source.CollectionListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CollectionListRepositoryImpl @Inject constructor(
    private val dataSource: CollectionListDataSource,
    private val mapper: CollectionDataMapper
) : CollectionListRepository {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getCollections(): Flow<PagingData<Collection>> {
        return Pager(
            config = PagingConfig(pageSize = 40, enablePlaceholders = false, prefetchDistance = 3),
            remoteMediator = CollectionListRemoteMediator(
                collectionListApi = dataSource.getCollectionListApi(),
                collectionListDao = dataSource.getNftDatabase().collectionListDao(),
                collectionKeyDao = dataSource.getNftDatabase().collectionListKeyDao(),
                mapper = mapper
            ),
            pagingSourceFactory = { dataSource.getNftDatabase().collectionListDao().getPagedCollections() }
        ).flow
    }

}