package com.bharatanve.workoutappdemo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendedPlanCard(
    imageId: Int = R.drawable.girl_bicep,
    exercisePlan : String,
    difficulty: String,
    onCardClick: () -> Unit

) {

    Card (
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(Constants.recommendedPlanCardHeight.dp)
            .width(Constants.recommendedPlanCardWidth.dp),
        onClick = {onCardClick()},
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.main_header),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0x774368EC)),
            )

            Column (modifier = Modifier
                .fillMaxHeight()
                .fillMaxSize(0.5f)
                .padding(start = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center) {

                OnCardText(text = exercisePlan, size = Constants.recommenededPlanOnCardTextSize, weight = FontWeight(800))
                OnCardText(text = difficulty, size = Constants.recommenededPlanOnCardTextSize, weight = FontWeight(700))


            }

            Row (horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom){

                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "image description",
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier.height((Constants.recommendedPlanCardHeight - 10).dp)
                )
            }

        }
    }
}