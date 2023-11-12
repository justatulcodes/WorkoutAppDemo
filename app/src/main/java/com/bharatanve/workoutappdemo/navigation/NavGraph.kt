package com.bharatanve.workoutappdemo.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.bharatanve.workoutappdemo.Constants
import com.bharatanve.workoutappdemo.network.APIManager
import com.bharatanve.workoutappdemo.windows.homeScreen

@Composable
fun SetupNavGraph(
    startDestination : String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    apiData: APIManager
) {

    NavHost(navController = navController, startDestination = startDestination) {


        composable(route = Constants.homePath) {

            homeScreen(navController = navController, apiData = apiData)

        }
        composable(route = Constants.statsPath) {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Stats Screen")
            }
        }
        composable(route = Constants.exercisesPath) {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Exercise Screen")
            }
        }
        composable(route = Constants.bookmarkPath) {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Bookmarks Screen")
            }
        }
        composable(route = Constants.profilePath) {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Profile Screen")
            }
        }
    }

}
