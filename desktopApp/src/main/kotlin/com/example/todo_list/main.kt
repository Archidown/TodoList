package com.example.todo_list

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.todo_list.view.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "TodoList",
    ) {
        App()
    }
}