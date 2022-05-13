package com.mukul.jan.ui_collections_list

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mukul.jan.ui_collections_list.components.CollectionListAppBar

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
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CollectionListAppBar()
        },
        content = {

        }
    )
}

@Preview()
@Composable
fun CollectionPreview() {
    CollectionList() {

    }
}










