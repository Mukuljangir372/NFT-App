package com.mukul.jan.collection_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CollectionList(
    onOpenDetail: () -> Unit
) {
    CollectionList(
        viewModel = hiltViewModel(),
        onOpenDetail = onOpenDetail
    )
}


@Composable
internal fun CollectionList(
    viewModel: CollectionListViewModel,
    onOpenDetail: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                 TopAppBar {

                 }
        },
        content = {

        }
        )
}











