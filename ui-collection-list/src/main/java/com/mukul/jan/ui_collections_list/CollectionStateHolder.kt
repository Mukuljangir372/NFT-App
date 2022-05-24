package com.mukul.jan.ui_collections_list

import androidx.paging.compose.LazyPagingItems
import com.mukul.jan.common_ui_components.UiMessage
import com.mukul.jan.data.collection.local.Collection

internal data class CollectionStateHolder(
    var collectionList: LazyPagingItems<Collection>? = null,
    val isRefreshing: Boolean = false,
    val uiMessage: UiMessage? = null,
){
    companion object{
        val Empty = CollectionStateHolder()
    }
}