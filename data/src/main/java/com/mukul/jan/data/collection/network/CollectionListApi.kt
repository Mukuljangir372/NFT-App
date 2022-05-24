package com.mukul.jan.data.collection.network

import com.mukul.jan.data.collection.network.CollectionEndpoints.COLLECTIONS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CollectionListApi {

    @GET(COLLECTIONS)
    suspend fun getCollections(
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
    ): Response<CollectionRes>

}