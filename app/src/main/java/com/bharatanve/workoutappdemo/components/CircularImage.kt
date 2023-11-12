package com.bharatanve.workoutappdemo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bharatanve.workoutappdemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircularImage(
    imageId : Int,
    size : Int,
    onClick  : () -> Unit
) {
    Card(onClick = { onClick() },
        modifier = Modifier.size(size.dp),
        shape = RoundedCornerShape(100.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            )
    }

}