package com.example.todo_list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetTaskEdit(
    title: String,
    description: String,
    date: String,
    onDismissRequest: () -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(Color.Red)
        ) {
            Text(title)
            Text(description)
            Text(date)
        }
    }
}