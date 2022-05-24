package com.mukul.jan.data.collection.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Collection(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val page: Int = 0,
    val slug: String? = "",
    val name: String? = "",
    val bannerUrl: String? = "",
    val createdDate: Date? = Date(),
    val description: String? = ""
)
