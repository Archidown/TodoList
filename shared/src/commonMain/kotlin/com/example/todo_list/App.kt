package com.example.todo_list


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import todolist.shared.generated.resources.Res
import todolist.shared.generated.resources.add_24px

@Composable
@Preview
fun App() {
    var tasks by remember { mutableStateOf(emptyList<Task>()) }
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = { ButtonAdd(onClick = { showDialog = true }) }
    ) { innerPadding ->
        Column(
            modifier=Modifier.padding(innerPadding)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 75.dp, horizontal = 20.dp),
                text = "My tasks",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            LazyColumn {
                items(items = tasks, key = { it.id }) { task ->
                    TaskItem()
                }
            }
            if (showDialog) {
                ModalBottomSheetItem(
                    onDismiss = { showDialog = false },
                    onAddTask = { title ->
                        tasks = tasks + Task(
                            id = (tasks.maxOfOrNull { it.id } ?: 0) + 1,
                            title = title
                        )
                    }
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
            painterResource(Res.drawable.add_24px),
            contentDescription = "floating button add"
        )
    }
}

