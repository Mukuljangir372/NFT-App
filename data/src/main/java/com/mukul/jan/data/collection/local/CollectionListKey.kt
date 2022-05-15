package com.mukul.jan.data.collection.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CollectionListKey(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val after: Int = 0,
    val before: Int = 0,
)
