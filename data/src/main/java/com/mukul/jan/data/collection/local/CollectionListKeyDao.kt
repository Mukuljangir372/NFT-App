package com.mukul.jan.data.collection.local

import androidx.room.*

@Dao
interface CollectionListKeyDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKey(key: CollectionListKey)

    @Transaction
    @Query("SELECT * FROM CollectionListKey")
    fun getKey(): CollectionListKey?

    @Transaction
    @Query("DELETE FROM CollectionListKey")
    fun deleteKey(): Int

}