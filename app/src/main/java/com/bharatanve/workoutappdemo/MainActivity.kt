package com.bharatanve.workoutappdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.bharatanve.workoutappdemo.navigation.BottomMenu
import com.bharatanve.workoutappdemo.navigation.SetupNavGraph
import com.bharatanve.workoutappdemo.network.APIManager
import com.bharatanve.workoutappdemo.ui.theme.WorkoutAppDemoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WorkoutAppDemoTheme {

                val apiData by remember {
                    mutableStateOf(APIManager())
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val modifier = Modifier.navigationBarsPadding().statusBarsPadding()

                    Scaffold ( modifier = modifier, bottomBar = { BottomMenu(navController = navController)}) {
                        SetupNavGraph(startDestination = Constants.homePath, navController = navController,
                        paddingValues = it, modifier = modifier.padding(10.dp), apiData = apiData)
                    }
                }
            }
        }
    }
}
