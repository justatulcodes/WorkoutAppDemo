package com.bharatanve.workoutappdemo.navigation

import com.bharatanve.workoutappdemo.Constants


sealed class Screen(val route : String) {
    object Home : Screen(route = Constants.homePath)
    object Stats : Screen(route = Constants.statsPath)
    object Bookmarks : Screen(route = Constants.bookmarkPath)
    object Exercise : Screen(route = Constants.exercisesPath)

}