package com.example.todo_list

import androidx.compose.ui.window.ComposeUIViewController
import com.example.todo_list.model.createTaskDao
import com.example.todo_list.view.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val taskDao = createTaskDao()
    return ComposeUIViewController { App(taskDao) }
}
