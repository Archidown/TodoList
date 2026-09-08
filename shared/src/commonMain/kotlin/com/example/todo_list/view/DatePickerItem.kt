package com.example.todo_list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_list.view.themes.Accent
import com.example.todo_list.view.utils.dateFormat
import com.example.todo_list.view.utils.toLocalDateUtc

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun DatePickerItem(onDatePicked: (String) -> Unit, onDismiss: () -> Unit) {
    val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
    val date = state.selectedDateMillis
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Accent
                )
            ){
                Text(
                    text = "Cancel",
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = {
                    date?.let { date ->
                        onDatePicked(date.toLocalDateUtc().dateFormat())
                        onDismiss()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Accent,
                    disabledContainerColor = Color.Transparent
                ),
                enabled = date != null
            ) {
                Text(
                    text = "OK",
                    fontSize = 20.sp
                )
            }
        }
        DatePicker(
            state = state,
            modifier = Modifier.padding(16.dp),
            colors = DatePickerDefaults.colors(
                containerColor = MaterialTheme.colorScheme.background,
                selectedDayContainerColor = Accent,
                dateTextFieldColors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                    focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
                ),
                todayContentColor = MaterialTheme.colorScheme.onPrimary,
                todayDateBorderColor = MaterialTheme.colorScheme.onPrimary,
                currentYearContentColor = MaterialTheme.colorScheme.onPrimary,
                selectedYearContainerColor = Accent
            )
        )
    }
}