package com.mukul.jan.data_android.collection.source


import com.mukul.jan.data.NftDatabase
import com.mukul.jan.data.collection.network.CollectionListApi
import com.mukul.jan.data.collection.source.CollectionListDataSource
import javax.inject.Inject

class CollectionListDataSourceImpl @Inject constructor(
    private val nftDatabase: NftDatabase,
    private val collectionListApi: CollectionListApi
) : CollectionListDataSource {

    override fun getCollectionListApi(): CollectionListApi {
        return collectionListApi
    }

    override fun getNftDatabase(): NftDatabase {
        return nftDatabase
    }

}