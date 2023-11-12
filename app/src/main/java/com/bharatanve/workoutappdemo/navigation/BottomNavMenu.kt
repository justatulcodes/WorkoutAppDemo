package com.bharatanve.workoutappdemo.navigation


import com.bharatanve.workoutappdemo.Constants
import com.bharatanve.workoutappdemo.R

sealed class BottomNavMenu (
    val route : String,
    val iconId : Int,
    val title: String
) {

    object Home: BottomNavMenu(Constants.homePath, R.drawable.home, "Home")
    object Stats: BottomNavMenu(Constants.statsPath, R.drawable.stats, "Stats")
    object Exercise: BottomNavMenu(Constants.exercisesPath, R.drawable.weight_life_menu, "Exercise")
    object Bookmakrs: BottomNavMenu(Constants.bookmarkPath, R.drawable.bookmark, "Saved")

}
