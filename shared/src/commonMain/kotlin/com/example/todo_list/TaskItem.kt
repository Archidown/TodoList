package com.example.todo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskItem(title: String, description: String, onClick: () -> Unit) {
    val checkedState = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        Checkbox(
            checkedState.value,
            onCheckedChange = { checkedState.value = true },
        )
        Column {
            Text(
                text = title,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 2.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text("Date")
        }

    }
}