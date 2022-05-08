package com.mukul.jan.collection_list

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

        },
        content = {

        }
        )
}

@Preview()
@Composable
fun CollectionPreview(){
    CollectionList(){

    }
}










