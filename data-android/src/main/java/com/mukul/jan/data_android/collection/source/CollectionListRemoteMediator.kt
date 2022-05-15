package com.mukul.jan.data_android.collection.source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.mukul.jan.data.collection.local.Collection
import com.mukul.jan.data.collection.local.CollectionListDao
import com.mukul.jan.data.collection.local.CollectionListKey
import com.mukul.jan.data.collection.local.CollectionListKeyDao
import com.mukul.jan.data.collection.mapper.CollectionDataMapper
import com.mukul.jan.data.collection.network.CollectionListApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalPagingApi::class)
class CollectionListRemoteMediator(
    private val collectionListApi: CollectionListApi,
    private val collectionListDao: CollectionListDao,
    private val collectionKeyDao: CollectionListKeyDao,
    private val mapper: CollectionDataMapper,
) : RemoteMediator<Int, Collection>() {

    private val pageLimit = 40

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Collection>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.APPEND -> {
                    val remoteKey = collectionKeyDao.getKey()
                    if (remoteKey?.after == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    remoteKey.after
                }
            }

            val collectionList = arrayListOf<Collection>()
            val call = collectionListApi.getCollections(offset = loadKey, limit = pageLimit)

            call.body()?.collections?.let {
                collectionList.addAll(mapper.networkCollectionListToCollectionList(it))

                withContext(Dispatchers.IO) {
                    if(loadType == LoadType.REFRESH){
                        collectionKeyDao.deleteKey()
                    }
                    var newKey = loadKey ?: 0
                    newKey += pageLimit

                    collectionKeyDao.insertKey(CollectionListKey(after = newKey))
                    collectionListDao.insertCollections(collectionList)
                }
            }
            MediatorResult.Success(endOfPaginationReached = collectionList.size < pageLimit)
        }catch (e: Exception){
            MediatorResult.Error(e)
        }
    }

}










