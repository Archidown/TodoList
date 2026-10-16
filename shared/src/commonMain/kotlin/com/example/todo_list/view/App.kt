package com.example.todo_list.view


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo_list.model.TaskDao
import com.example.todo_list.view.navigation.AllTasks
import com.example.todo_list.view.navigation.IncomingTasks
import com.example.todo_list.view.navigation.Settings
import com.example.todo_list.view.navigation.TodayTasks
import com.example.todo_list.view.themes.Accent
import com.example.todo_list.view.themes.AppTheme
import com.example.todo_list.view.themes.OnAccent
import com.example.todo_list.viewModel.TaskViewModel


@Composable
fun App(taskDao: TaskDao) {

    var showDialog by remember { mutableStateOf(false) }
    val navController = rememberNavController()
    val taskViewModel = viewModel { TaskViewModel(taskDao) }

    AppTheme {
        Scaffold(
            floatingActionButton = {
                ButtonAdd(onClick = {
                    showDialog = true
                })
            },
            bottomBar = {
                ToDoListNavigationBar(navController)
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = AllTasks
            ) {
                composable<AllTasks> { AllTasksScreen(innerPadding, taskViewModel, showDialog) }
                composable<TodayTasks> { TodayTasksScreen() }
                composable<IncomingTasks> { IncomingTasksScreen() }
                composable<Settings> { SettingsScreen() }
            }
            if (showDialog) {
                ModalBottomSheetTaskCreator(
                    onDismiss = { showDialog = false },
                    onAddTask = { title, description, date ->
                        if (taskViewModel.checkTask(title, date)) {
                            taskViewModel.addTask(title, description, date)
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun ButtonAdd(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = Accent
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "button add task",
            tint = OnAccent
        )
    }
}

