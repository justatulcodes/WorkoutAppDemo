package com.bharatanve.workoutappdemo.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bharatanve.workoutappdemo.R
import com.bharatanve.workoutappdemo.ui.theme.poppinsFontFamily

@Composable
fun BottomMenu(navController: NavController) {
    val menuItem = listOf(
        BottomNavMenu.Home,
        BottomNavMenu.Stats,
        BottomNavMenu.Exercise,
        BottomNavMenu.Bookmakrs
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 2.dp
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        var currentRoute = navBackStackEntry?.destination?.route
        if(currentRoute == null){
            currentRoute = BottomNavMenu.Home.route
        }

        menuItem.forEach {
            BottomNavigationItem(
                label = { Text(text = it.title,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 24.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(600),
                        )
                )},
                alwaysShowLabel = false,
                unselectedContentColor = MaterialTheme.colorScheme.onSurface,
                selected = currentRoute == it.route,
                icon = {
                    if(currentRoute != it.route) {
                        Icon(
                            painter = painterResource(id = it.iconId),
                            contentDescription = it.title,
                        )
                    }else {
                        Icon(
                            painter = painterResource(id = R.drawable.dot),
                            contentDescription = it.title,
                            tint = Color.Red,
                            modifier = Modifier.size(10.dp)
                        )
                    }
                },
                onClick = {
                    navController.navigate(it.route){
                        navController.graph.startDestinationRoute?.let {
                                route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                )
        }
    }
}