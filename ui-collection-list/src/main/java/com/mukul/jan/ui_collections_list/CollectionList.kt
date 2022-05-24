package com.mukul.jan.ui_collections_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.mukul.jan.common_ui_components.rememberStateWithLifecycle
import com.mukul.jan.common_ui_components.ui.CollectionCard
import com.mukul.jan.common_ui_res.R
import com.mukul.jan.data.collection.local.Collection

@Composable
fun CollectionList(
    onOpenDetail: (collectionSlum: String) -> Unit
) {
    val viewModel = hiltViewModel<CollectionListViewModel>()
    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)

    val collectionState = viewModel.getLiveCollectionList().collectAsLazyPagingItems()
    state.collectionList = collectionState

    CollectionList(
        state = state,
        onMessageShown = { viewModel.clearUiMsg() },
        onOpenDetail = onOpenDetail
    )
}
@Composable
internal fun CollectionList(
    state: CollectionStateHolder,
    onMessageShown: () -> Unit,
    onOpenDetail: (collectionSlum: String) -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    state.uiMessage?.message?.let { msg ->
        LaunchedEffect(key1 = msg, block = {
            scaffoldState.snackbarHostState.showSnackbar(msg)
            onMessageShown()
        })
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CollectionListAppBar()
        },
        content = {
            CollectionListView(
                modifier = Modifier.fillMaxSize(),
                list = state.collectionList,
                openDetails = { onOpenDetail(it) }
            )
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

@Composable
private fun CollectionListView(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<Collection>?,
    openDetails: (CollectionSlum: String) -> Unit
){
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 10.dp,
            vertical = 10.dp
        ),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ){
        list?.let {
            items(it){ collection ->
                collection?.let { item ->
                    CollectionCard(
                        modifier = Modifier.height(280.dp),
                        collection = item,
                        onClick = { openDetails(item.slug ?: "") }
                    )
                }
            }
        }

    }
}









