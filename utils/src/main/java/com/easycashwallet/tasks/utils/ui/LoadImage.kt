package com.easycashwallet.tasks.utils.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun LoadImage(url: String, modifier: Modifier = Modifier,contentScale: ContentScale = ContentScale.Fit) {
    Image(
        painter = rememberAsyncImagePainter(
            model = url,
            error = rememberVectorPainter(Icons.Filled.BrokenImage)
        ),
        contentDescription = null,
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        contentScale = contentScale,

        )
}