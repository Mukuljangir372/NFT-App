package com.mukul.jan.data.collection.local

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface CollectionListDao {

    @Query("SELECT * FROM Collection")
    fun getPagedCollections() : PagingSource<Int,Collection>

    @Transaction
    fun insertCollections(collections: List<Collection>){
        insertCollectionList(collections)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCollectionList(collections: List<Collection>)

    @Query("SELECT * FROM COLLECTION WHERE id =:id")
    fun deleteCollection(id: Int) : Int

    @Query("DELETE FROM Collection")
    fun deleteAll(): Int

}