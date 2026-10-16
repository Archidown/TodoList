package com.example.todo_list.view.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route

@Serializable
object AllTasks : Route

@Serializable
object TodayTasks : Route

@Serializable
object IncomingTasks : Route

@Serializable
object Settings : Route

