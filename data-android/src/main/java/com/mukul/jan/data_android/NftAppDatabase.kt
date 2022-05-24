package com.mukul.jan.data_android

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mukul.jan.data.NftDatabase
import com.mukul.jan.data.collection.local.Collection
import com.mukul.jan.data.collection.local.CollectionListKey
import com.mukul.jan.data_android.utils.DatabaseConverters

@Database(
    entities = [Collection::class, CollectionListKey::class],
    version = 2
)
@TypeConverters(DatabaseConverters::class)
abstract class NftAppDatabase : RoomDatabase(), NftDatabase