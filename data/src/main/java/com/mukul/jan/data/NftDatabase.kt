package com.mukul.jan.data

import com.mukul.jan.data.collection.local.CollectionListDao
import com.mukul.jan.data.collection.local.CollectionListKeyDao

interface NftDatabase {
    //collection ------------------------------------------------------------------------------
    fun collectionListDao() : CollectionListDao
    fun collectionListKeyDao() : CollectionListKeyDao

}