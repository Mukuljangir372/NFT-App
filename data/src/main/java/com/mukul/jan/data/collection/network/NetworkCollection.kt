package com.mukul.jan.data.collection.network

import com.google.gson.annotations.SerializedName

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
    @SerializedName("description")
    val description: String? = ""
)
