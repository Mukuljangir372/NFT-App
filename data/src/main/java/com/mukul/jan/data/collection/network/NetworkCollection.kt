package com.mukul.jan.data.collection.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class CollectionRes(
    @SerializedName("collections")
    val collections: ArrayList<NetworkCollection>? = null
)

data class NetworkCollection(
    @SerializedName("slug")
    val slug: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("banner_image_url")
    val bannerUrl: String? = "",
    @SerializedName("created_date")
    val createdDate: Date? = null,
    @SerializedName("description")
    val description: String? = ""
)
