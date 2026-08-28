package com.example.todo_list

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.todo_list.model.createTaskDao
import com.example.todo_list.view.App

fun main() = application {
    val dao = createTaskDao()
    Window(
        onCloseRequest = ::exitApplication,
        title = "TodoList",
    ) {
        App(dao)
    }
}