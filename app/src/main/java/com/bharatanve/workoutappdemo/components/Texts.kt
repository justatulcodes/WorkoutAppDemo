package com.bharatanve.workoutappdemo.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bharatanve.workoutappdemo.ui.theme.montserratFontFamily
import com.bharatanve.workoutappdemo.ui.theme.poppinsFontFamily

@Composable
fun HeaderText(text: String, size: Int, color : Color = MaterialTheme.colorScheme.onBackground) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = size.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight(500),
            color = color,
        )
    )
}

@Composable
fun OnCardText(text: String, size: Int, weight: FontWeight = FontWeight(800), color: Color = MaterialTheme.colorScheme.background) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = size.sp,
            lineHeight = 18.sp,
            fontFamily = montserratFontFamily,
            fontWeight = weight,
            color = color,
        )
    )
}

@Composable
fun OnStatsCardText(
    text: String,
    size: Int,
    weight: FontWeight = FontWeight((500)),
    color : Color = MaterialTheme.colorScheme.background
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = size.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = weight,
            color = color,
            lineHeight = size.sp
        )
    )
}
