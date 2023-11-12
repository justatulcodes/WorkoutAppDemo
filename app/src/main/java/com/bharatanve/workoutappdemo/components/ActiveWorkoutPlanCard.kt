package com.bharatanve.workoutappdemo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bharatanve.workoutappdemo.Constants
import com.bharatanve.workoutappdemo.R
import com.bharatanve.workoutappdemo.ui.theme.poppinsFontFamily

@Composable
fun ActiveWorkoutPlanCard(
    headingString: String,
    progressCount: String,
    onClickContinue : () -> Unit,
    headerImageId : Int = R.drawable.header_imager
) {
    Card (
        shape = RoundedCornerShape(Constants.cardRoundedCornerSize.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(Constants.activeWorkoutCardHeight.dp)
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
                    .background(color = Color(0x4479F67E)),
            )

            Row (Modifier.fillMaxSize()){
                Image(
                    modifier = Modifier.weight(1f),
                    painter = painterResource(id = headerImageId),
                    contentDescription = "image description",
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.BottomStart
                )

                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()) {

                    OnCardText(text = headingString,
                        size = Constants.activeWorkoutOnCardTextSize, weight = FontWeight(700)
                    )
                    
                    ProgressBarCustom(progressCount = progressCount.dropLast(1).toInt())

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFB0B31A)
                        ),
                        modifier = Modifier
                            .padding(0.dp)
                            .height(30.dp)) {
                        Text(
                            text = "CONTINUE",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFEFFBB),
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                }
            }
        }
    }

}