package com.mukul.jan.common_ui_components.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mukul.jan.common_ui_components.R
import com.mukul.jan.data.collection.local.Collection

@Preview
@Composable
private fun CollectionCardPreview() {
    CollectionCard(
        collection = Collection(
            id = 1,
            name = "Ape Collections",
            description = "This collection is used by most famous nft lovers",
        ),
        modifier = Modifier
            .width(250.dp)
            .height(250.dp),
    ) {}
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CollectionCard(
    collection: Collection,
    modifier: Modifier,
    onClick: (Collection) -> Unit
) {
    Card(
        modifier = modifier.clip(RoundedCornerShape(5.dp)),
        onClick = {
            onClick(collection)
        }
    ) {
        Box {
            AsyncImage(
                modifier = modifier,
                model = collection.bannerUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.monkey)
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart),
                color = MaterialTheme.colors.surface.copy(alpha = 0.7f),
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 6.dp,
                        top = 8.dp,
                        bottom = 8.dp,
                    )
                ) {
                    Text(
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Medium,
                        text = collection.name ?: "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (!collection.description.isNullOrBlank()) {
                        Text(
                            style = MaterialTheme.typography.subtitle1,
                            text = collection.description ?: "",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

            }
        }
    }
}















