package com.bharatanve.workoutappdemo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bharatanve.workoutappdemo.Constants
import com.bharatanve.workoutappdemo.R

@Composable
fun CategoryCard(
    exerciseFocus: String,
    exerciseCount: String,
    focusImageId: Int = R.drawable.weight_lift,
    onCardClick: () -> Unit
) {
    Card (
        shape = RoundedCornerShape(Constants.cardRoundedCornerSize.dp),
        modifier = Modifier
            .height(Constants.categoriesCardHeight.dp)
            .padding(5.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.tertiary_header),
                contentDescription = "image description",
                contentScale = ContentScale.FillWidth
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0x4479F67E)),
            )

            Column (modifier = Modifier.fillMaxSize().padding(top = 15.dp, start = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top) {

                OnCardText(text = exerciseFocus, size = Constants.categoriesOnCardtitleTextSize, weight = FontWeight(800))

                OnCardText(text = "$exerciseCount Exercises", size = Constants.categoriesOnCardSubtitleTextSize, weight = FontWeight(600))


            }


            Row (horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = focusImageId),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.CenterEnd,
                )
            }

        }
    }
}