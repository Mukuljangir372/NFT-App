package com.mukul.jan.ui_collections_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mukul.jan.common_ui_res.R


@Preview()
@Composable
fun CollectionPreview() {
    CollectionList {}

}

@Composable
fun CollectionList(
    onOpenDetail: (collectionId: Int) -> Unit
) {
    CollectionList(
        viewModel = hiltViewModel(),
        onOpenDetail = onOpenDetail
    )
}


@Composable
internal fun CollectionList(
    viewModel: CollectionListViewModel,
    onOpenDetail: (collectionId: Int) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CollectionListAppBar()
        },
        content = {
            LazyColumn {

            }
        }
    )
}

@Composable
internal fun CollectionListAppBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface,
        title = {
            Text(text = stringResource(id = R.string.dashboard))
        },
    )
}











