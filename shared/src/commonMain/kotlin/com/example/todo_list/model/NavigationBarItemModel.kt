package com.example.todo_list.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.todo_list.view.icons.CalendarIcon
import com.example.todo_list.view.icons.SettingsIcon
import com.example.todo_list.view.icons.TasksIcon
import com.example.todo_list.view.icons.TodayIcon

data class NavigationBarItemModel(
    val icon: ImageVector,
    val label: String
)

val navBarItems = listOf(
    NavigationBarItemModel(
        icon = TasksIcon,
        label = "Tasks"
    ),
    NavigationBarItemModel(
        icon = TodayIcon,
        label = "Today"
    ),
    NavigationBarItemModel(
        icon = CalendarIcon,
        label = "Incoming"
    ),
    NavigationBarItemModel(
        icon = SettingsIcon,
        label = "Settings"
    )
)