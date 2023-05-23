package com.example.gallery_compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun GalleryScreen() {

    val images = remember {
        mutableStateListOf(
            "https://images.pexels.com/photos/14989639/pexels-photo-14989639/free-photo-of-montanas-cielo-nubes-techo.jpeg",
            "https://images.pexels.com/photos/16248184/pexels-photo-16248184/free-photo-of-ciudad-restaurante-vacaciones-gente.jpeg",
            "https://images.pexels.com/photos/15850465/pexels-photo-15850465/free-photo-of-rojo-flores-verano-entrada.jpeg",
            "https://images.pexels.com/photos/16177510/pexels-photo-16177510/free-photo-of-madera-ciudad-gente-arte.jpeg",
            "https://images.pexels.com/photos/15964785/pexels-photo-15964785/free-photo-of-moda-mujer-modelo-vestido.jpeg",
            "https://images.pexels.com/photos/16307711/pexels-photo-16307711/free-photo-of-paisaje-desierto-esteril-cabrio.jpeg",
            "https://images.pexels.com/photos/16494849/pexels-photo-16494849/free-photo-of-madera-ligero-amanecer-paisaje.jpeg",
            "https://images.pexels.com/photos/16708463/pexels-photo-16708463/free-photo-of-carretera-paisaje-campo-verano.jpeg",
            "https://images.pexels.com/photos/15988882/pexels-photo-15988882/free-photo-of-ciudad-arte-edificio-construccion.jpeg",
            "https://images.pexels.com/photos/16881620/pexels-photo-16881620/free-photo-of-nunca-tan-lejos-de-la-realidad.jpeg"
        )
    }

    val pagerState = rememberPagerState()

    Scaffold(modifier = Modifier.padding(vertical = 48.dp)) {
        HorizontalPager(
            pageCount = images.size,
            state = pagerState,
            modifier = Modifier.padding(it)
        ) { page ->
            val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
            ImageGallery(imageUrl = images[page], pageOffset = pageOffset)
        }
    }

}