package com.mukul.jan.data.collection.source

import com.mukul.jan.data.NftDatabase
import com.mukul.jan.data.collection.network.CollectionListApi

interface CollectionListDataSource {
    fun getCollectionListApi() : CollectionListApi
    fun getNftDatabase() : NftDatabase
}