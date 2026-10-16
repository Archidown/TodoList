package com.example.todo_list.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
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
import com.example.todo_list.viewModel.TaskViewModel

@Composable
fun AllTasksScreen(innerPadding: PaddingValues, taskViewModel: TaskViewModel, showDialog: Boolean) {
    val taskList = taskViewModel.taskList.collectAsStateWithLifecycle()
    var currentTaskId by remember { mutableStateOf<Long?>(null) }
    val currentTask = taskList.value.find { it.id == currentTaskId }

    Column(
        modifier = Modifier.padding(innerPadding)
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 75.dp, horizontal = 20.dp),
            text = "My tasks",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )
        LazyColumn {
            items(items = taskList.value, key = { it.id }) { task ->
                TaskItem(
                    task,
                    onClick = {
                        currentTaskId = task.id
                    },
                    onFinished = { task ->
                        taskViewModel.checkBoxRemoveTask(task)
                    }
                )
            }
        }
        currentTask?.let { task ->
            ModalBottomSheetTaskEdit(
                task = task,
                onDismiss = { currentTaskId = null },
                onSave = { title, description, date ->
                    taskViewModel.taskEdit(
                        task = task,
                        newTitle = title,
                        newDescription = description,
                        newDate = date
                    )
                },
                onFinished = { task ->
                    taskViewModel.checkBoxRemoveTask(task)
                    currentTaskId = null
                }
            )
        }
    }
}