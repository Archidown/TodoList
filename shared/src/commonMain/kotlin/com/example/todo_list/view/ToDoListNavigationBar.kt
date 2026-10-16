package com.example.todo_list.view

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.todo_list.model.navBarItems

@Composable
fun ToDoListNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var selected by remember { mutableStateOf(0) }
    NavigationBar {
        navBarItems.forEachIndexed { index, model ->
            NavigationBarItem(
                //To get the right icon selected on the NavBar
                selected = currentDestination?.hasRoute(model.route::class) == true,
                onClick = {
                    selected = index
                    navController.navigate(model.route) {
                        //to prevent bottom bar to accumulate destination and to go to the starDestination
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                icon = { Icon(imageVector = model.icon, contentDescription = model.label) },
                label = { Text(model.label) },
            )
        }
    }
}

