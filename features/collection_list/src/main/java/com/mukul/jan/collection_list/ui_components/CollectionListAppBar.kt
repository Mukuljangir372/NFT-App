package com.mukul.jan.collection_list.ui_components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mukul.jan.collection_list.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*


@Composable
internal fun CollectionListAppBar(
    onSavedClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface,
        title = {

        },
        actions = {
            CollectionAppBarActions(onSavedClick)
        }
    )
}

@Composable
internal fun CollectionAppBarActions(
    onSavedClick: () -> Unit
) {
    IconButton(
        onClick = onSavedClick
    ) {
        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
    }
}

@Preview
@Composable
internal fun CollectionAppBarPreview() {
    CollectionListAppBar({ /*Nothing*/ })
}
