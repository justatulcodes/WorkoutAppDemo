package com.bharatanve.workoutappdemo.windows

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bharatanve.workoutappdemo.Constants
import com.bharatanve.workoutappdemo.R
import com.bharatanve.workoutappdemo.components.ActiveWorkoutPlanCard
import com.bharatanve.workoutappdemo.components.CategoryCard
import com.bharatanve.workoutappdemo.components.CircularImage
import com.bharatanve.workoutappdemo.components.HeaderText
import com.bharatanve.workoutappdemo.components.OnStatsCardText
import com.bharatanve.workoutappdemo.components.RecommendedPlanCard
import com.bharatanve.workoutappdemo.components.SearchField
import com.bharatanve.workoutappdemo.components.StatsIconButton
import com.bharatanve.workoutappdemo.model.Category
import com.bharatanve.workoutappdemo.model.Section1
import com.bharatanve.workoutappdemo.model.Section2
import com.bharatanve.workoutappdemo.model.Section3
import com.bharatanve.workoutappdemo.model.Section4
import com.bharatanve.workoutappdemo.navigation.BottomMenu
import com.bharatanve.workoutappdemo.network.APIManager
import com.bharatanve.workoutappdemo.ui.theme.poppinsFontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    apiData: APIManager,
) {
    var searchString by remember{ mutableStateOf("") }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF62CADE), Color(0xFF8ECCA1),)
    )
    val gradient2 = Brush.verticalGradient(
        colors = listOf(Color(0xFFC9DBE9), Color(0xFFC3F2C8),)
    )

    Scaffold (
        topBar = {
            Surface(shadowElevation = 1.dp,
                color = MaterialTheme.colorScheme.background) {
                topBar(navController)
            }
        },
        bottomBar =  { BottomMenu(navController = navController) },
        modifier = modifier) {
        Column(
            modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                ) {
            Spacer(modifier = Modifier.height(15.dp))

            ActiveWorkoutPlanSection(searchString, { searchString = it },
                screenData = apiData.HomeDataresponse.value.data!!.section_1)

            Spacer(modifier = Modifier.height(15.dp))

            StatsSection(gradient1 = gradient, gradient2 = gradient2,
                screenData = apiData.HomeDataresponse.value.data!!.section_2)

            Spacer(modifier = Modifier.height(20.dp))

            RecommendedPlanSection(screenData = apiData.HomeDataresponse.value.data!!.section_3)

            Spacer(modifier = Modifier.height(20.dp))

            CategoriesSection(
                screenData = apiData.HomeDataresponse.value.data!!.section_4)

            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(navController: NavController) {
    TopAppBar(title = {
        Column {
            HeaderText(text = "Good Morning 🔥", size = Constants.headerTextSize)
            HeaderText(text = "RIA", size = Constants.userNameTextSize)
        }
    },
        actions = {
            CircularImage(imageId = R.drawable.profile_pic_girl, size = Constants.profilePicSize,
                onClick = {
                    navController.navigate(Constants.profilePath)
                })
        },
        modifier = Modifier.padding(horizontal = 15.dp),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        )
    )
}

@Composable
fun ActiveWorkoutPlanSection(
    searchString: String,
    onSearchStringChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    screenData: Section1
) {


    Column(modifier.padding(horizontal = 15.dp)) {
        SearchField(
            searchString = searchString,
            onSearchStringChange = { onSearchStringChange(it) },
            placeholder = "Search Exercise",
            onTrailingIconClick = { },
            onLeadingIconClick = { },
            leadingIconId = R.drawable.camera,
            trailingIconId = R.drawable.search,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(21.dp))

        HeaderText(text = "Active Workout Plan", size = Constants.headerTextSize)

        Spacer(modifier = Modifier.height(6.dp))

        ActiveWorkoutPlanCard(headingString = screenData.plan_name,
            progressCount = screenData.progress, onClickContinue = { })
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsSection(gradient1: Brush, gradient2: Brush, screenData: Section2) {

    Column(Modifier.padding(horizontal = 15.dp)) {

        HeaderText(
            text = "Enhance your journey with AI tracker",
            size = Constants.headerTextSize
        )
        Spacer(modifier = Modifier.height(6.dp))

        Card(
            shape = RoundedCornerShape(topStart = Constants.cardRoundedCornerSize.dp,
                topEnd = Constants.cardRoundedCornerSize.dp),
            modifier = Modifier
                .height(Constants.statsCardTopSectionHeight.dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {

            Box(modifier = Modifier
                .fillMaxSize()
                .background(gradient1)) {
                Column (Modifier.padding(10.dp)){

                    Row (
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row (horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.weight(1f)) {
                            StatsIconButton(iconIc = R.drawable.bicep,
                                onClickAction = { },
                                iconTint = Color(0xFF9747FF))
                            Spacer(modifier = Modifier.width(10.dp))
                            Column (verticalArrangement = Arrangement.Center) {
                                OnStatsCardText(text = "Accuracy", size = Constants.onStatsCardTextSize)
                                OnStatsCardText(text = screenData.accuracy, size = Constants.onStatsCardTextSize, weight = FontWeight(400))

                            }
                        }

                        Row (modifier = Modifier.weight(1f)) {
                            StatsIconButton(iconIc = R.drawable.timer,
                                onClickAction = { },
                                iconTint = Color(0xFFE21313))
                            Spacer(modifier = Modifier.width(10.dp))
                            Column (verticalArrangement = Arrangement.Center) {
                                OnStatsCardText(text = "Workout Duration", size = Constants.onStatsCardTextSize)
                                OnStatsCardText(text = screenData.workout_duration, size = Constants.onStatsCardTextSize, weight = FontWeight(400))

                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Row (horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.weight(1f)){
                            StatsIconButton(iconIc = R.drawable.weight_lift_guy,
                                onClickAction = { },
                                iconTint = Color(0xFF2CDAE5))
                            Spacer(modifier = Modifier.width(10.dp))
                            Column (verticalArrangement = Arrangement.Center) {
                                OnStatsCardText(text = "Reps", size = Constants.onStatsCardTextSize)
                                OnStatsCardText(text = screenData.reps.toString(), size = Constants.onStatsCardTextSize, weight = FontWeight(400))

                            }
                        }

                        Row (modifier = Modifier.weight(1f)) {
                            StatsIconButton(iconIc = R.drawable.fire,
                                onClickAction = { },
                                iconTint = Color(0xFF9EA00F ))
                            Spacer(modifier = Modifier.width(10.dp))
                            Column (verticalArrangement = Arrangement.Center) {
                                OnStatsCardText(text = "Calories Burn", size = Constants.onStatsCardTextSize)
                                OnStatsCardText(text = screenData.calories_burned.toString(), size = Constants.onStatsCardTextSize, weight = FontWeight(400))

                            }
                        }
                    }



                }
            }
        }

        Card(
            Modifier
                .height(Constants.statsCardBottomSectionHeight.dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
            ,
            elevation = CardDefaults.cardElevation(2.dp),
                    shape = RoundedCornerShape(bottomEnd = Constants.cardRoundedCornerSize.dp,
                bottomStart = Constants.cardRoundedCornerSize.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(gradient2)) {

                Row (horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {

                    StatsIconButton(iconIc = R.drawable.frame, onClickAction = { /*TODO*/ },
                        iconTint = Color.Black)

                    Spacer(Modifier.width(15.dp))

                    Column(Modifier.weight(1f)) {
                        OnStatsCardText(text = "200+ people tracked their fitness",
                            size = 12, color = Color.Black)
                        Row {
                            OnStatsCardText(text = "Why haven't you joined them yet? ",
                                size = 10, color = Color.Black)
                            OnStatsCardText(text = "TRY NOW",
                                size = 10, color = Color.Black, weight = FontWeight(1000)
                            )
                        }


                    }
                }

            }
        }

    }


}

@Composable
fun RecommendedPlanSection(screenData: Section3
) {
    Row {

        Row (Modifier.padding(horizontal = 15.dp)){
            HeaderText(text = "Recommended Plan", size = Constants.headerTextSize)

            Spacer(modifier = Modifier
                .weight(1f)
                .padding(horizontal = 0.dp))
            Text(
                text = "See All",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFBBBE15),
                    textAlign = TextAlign.Center,
                )
            )

        }
    }

    Spacer(modifier = Modifier.height(6.dp))


    Row (Modifier.horizontalScroll(rememberScrollState())) {

        Spacer(modifier = Modifier.width(15.dp))

        RecommendedPlanCard(exercisePlan = screenData.plan_1.plan_name,
            difficulty = screenData.plan_1.difficulty) {
            //TODO
        }

        Spacer(modifier = Modifier.width(15.dp))


        RecommendedPlanCard(exercisePlan = screenData.plan_2.plan_name,
            difficulty = screenData.plan_2.difficulty) {
            //TODO
        }

        Spacer(modifier = Modifier.width(15.dp))


        RecommendedPlanCard(exercisePlan = "TONED ARM", difficulty = "Beginner") {
            //TODO
        }

        Spacer(modifier = Modifier.width(15.dp))

        RecommendedPlanCard(exercisePlan = "TONED ARM", difficulty = "Beginner") {
            //TODO
        }

        Spacer(modifier = Modifier.width(15.dp))

    }

}

@Composable
fun CategoriesSection(
    screenData: Section4
) {
    Row(Modifier.padding(horizontal = 15.dp)) {
        HeaderText(text = "Categories", size = Constants.headerTextSize)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See All",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(600),
                color = Color(0xFFBBBE15),
                textAlign = TextAlign.Center,
            )
        )
    }

    Spacer(modifier = Modifier.height(6.dp))

    Row (
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)){

        Row (Modifier.weight(1f)){
            CategoryCard(exerciseFocus = screenData.category_1.category_name, exerciseCount = screenData.category_1.no_of_exercises) {
                //TODO
            }
        }
        Row (Modifier.weight(1f)){
            CategoryCard(exerciseFocus = screenData.category_2.category_name, exerciseCount = screenData.category_2.no_of_exercises) {
                //TODO
            }
        }

    }
}
