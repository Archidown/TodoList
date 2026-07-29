package com.example.todo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun DatePickerItem(onDatePicked: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.background(Color.White)
    ) {
        val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
        DatePicker(
            state = state,
            modifier = Modifier.padding(16.dp),
            colors = DatePickerDefaults.colors(Color.White)
        )
        val date = state.selectedDateMillis
        if (date != null) {
            val correctDate = Instant.fromEpochMilliseconds(date)
                .toLocalDateTime(TimeZone.UTC)
                .date
            onDatePicked(correctDate.toString())

        }
        Button(onClick = {}) {
            Text("Ok")
        }
    }
}