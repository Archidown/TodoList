package com.example.todo_list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetDatePicker(onDismiss: () -> Unit, onDatePicked: (String) -> Unit) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        dragHandle = null
    ){

        DatePickerItem(onDatePicked, onDismiss)
    }
}

