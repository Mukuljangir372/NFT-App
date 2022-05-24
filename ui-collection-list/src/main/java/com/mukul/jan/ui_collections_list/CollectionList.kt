package com.mukul.jan.ui_collections_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mukul.jan.common_ui_components.ui.CollectionCard
import com.mukul.jan.common_ui_res.R
import com.mukul.jan.data.collection.local.Collection

@Composable
fun CollectionList(
    onOpenDetail: (collectionSlum: String) -> Unit
) {
    CollectionList(
        viewModel = hiltViewModel(),
        onOpenDetail = onOpenDetail
    )
}
@Composable
internal fun CollectionList(
    viewModel: CollectionListViewModel,
    onOpenDetail: (collectionSlum: String) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CollectionListAppBar()
        },
        content = {
            CollectionListView(
                modifier = Modifier.fillMaxSize(),
                list = arrayListOf(),
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
    list: List<Collection>,
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
        items(list){ collection ->
            CollectionCard(
                modifier = Modifier.height(280.dp),
                collection = collection,
                onClick = { openDetails(collection.slug) }
            )
        }
    }
}









