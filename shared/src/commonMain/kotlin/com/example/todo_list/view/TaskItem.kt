package com.example.todo_list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_list.model.TaskModel

@Composable
fun TaskItem(
    task: TaskModel,
    onClick: () -> Unit,
    onFinished: (TaskModel) -> Unit
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(12.dp)
    ) {
        Checkbox(
            modifier = Modifier
                .size(20.dp)
                .padding(8.dp),
            checked = task.isDone,
            onCheckedChange = {
                onFinished(task)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.outline,
                uncheckedColor = MaterialTheme.colorScheme.outline
            ),
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = task.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            if (task.description != "")
                Text(
                    text = task.description,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            Text(
                text = task.date,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

    }
    HorizontalDivider(
        color = MaterialTheme.colorScheme.outlineVariant,
        modifier = Modifier.padding(8.dp)
    )
}