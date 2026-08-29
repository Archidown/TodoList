package com.example.todo_list.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo_list.model.TaskDao
import com.example.todo_list.viewModel.TaskViewModel


@Composable
fun App(taskDao: TaskDao) {
    val taskViewModel = viewModel { TaskViewModel(taskDao) }
    val taskList = taskViewModel.taskList.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }
    var showTaskEdit by remember { mutableStateOf(false) }
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }
    var taskDate by remember { mutableStateOf("") }
    Scaffold(
        floatingActionButton = {
            ButtonAdd(onClick = {
                showDialog = true
            })
        }//showDialog is read just a visual bug
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 75.dp, horizontal = 20.dp),
                text = "My tasks",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            LazyColumn {
                items(items = taskList.value, key = { it.id }) { task ->
                    TaskItem(
                        task,
                        onClick = {
                            showTaskEdit = true
                            taskTitle = task.title
                            taskDescription = task.description
                            taskDate = task.date
                        },
                        onFinished = { task ->
                            taskViewModel.checkBoxRemoveTask(task)
                        }
                    )
                }
            }
            if (showDialog) {
                ModalBottomSheetItem(
                    onDismiss = { showDialog = false },
                    onAddTask = { title, description, date ->
                        if (taskViewModel.checkTask(title, date)) {
                            taskViewModel.addTask(title, description, date)
                            showDialog = false
                        }
                    }
                )
            }
            if (showTaskEdit) {
                ModalBottomSheetTaskEdit(
                    title = taskTitle,
                    description = taskDescription,
                    date = taskDate,
                    onDismissRequest = { showTaskEdit = false },
                )
            }
        }
    }
}


@Composable
fun ButtonAdd(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "button add task"
        )
    }
}

