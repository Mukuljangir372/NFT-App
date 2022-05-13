package com.mukul.jan.ui_collections_list.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mukul.jan.common_ui_res.R


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

@Preview
@Composable
internal fun CollectionAppBarPreview() {
    CollectionListAppBar()
}
