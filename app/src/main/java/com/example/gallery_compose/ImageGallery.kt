package com.example.gallery_compose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ImageGallery(imageUrl: String, pageOffset: Float) {
    val matrix = remember { ColorMatrix() }

    val imageSize by animateFloatAsState(
        targetValue = if (pageOffset != 0.0F) 0.75F else 1F,
        animationSpec = tween(300),
        label = ""
    )

    LaunchedEffect(imageSize) {
        val saturation = if (pageOffset != 0.0F) 0F else 1F
        matrix.setToSaturation(saturation)
    }

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl).build(),
        contentDescription = imageUrl,
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.colorMatrix(matrix),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .graphicsLayer {
                scaleX = imageSize
                scaleY = imageSize
            }
    )
}