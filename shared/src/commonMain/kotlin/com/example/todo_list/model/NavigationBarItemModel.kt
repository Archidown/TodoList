package com.example.todo_list.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.todo_list.view.icons.CalendarIcon
import com.example.todo_list.view.icons.SettingsIcon
import com.example.todo_list.view.icons.TasksIcon
import com.example.todo_list.view.icons.TodayIcon
import com.example.todo_list.view.navigation.AllTasks
import com.example.todo_list.view.navigation.IncomingTasks
import com.example.todo_list.view.navigation.Route
import com.example.todo_list.view.navigation.Settings
import com.example.todo_list.view.navigation.TodayTasks

data class NavigationBarItemModel(
    val icon: ImageVector,
    val label: String,
    val route: Route
)

val navBarItems = listOf(
    NavigationBarItemModel(
        icon = TasksIcon,
        label = "Tasks",
        route = AllTasks
    ),
    NavigationBarItemModel(
        icon = TodayIcon,
        label = "Today",
        route = TodayTasks
    ),
    NavigationBarItemModel(
        icon = CalendarIcon,
        label = "Incoming",
        route = IncomingTasks
    ),
    NavigationBarItemModel(
        icon = SettingsIcon,
        label = "Settings",
        route = Settings
    )
)