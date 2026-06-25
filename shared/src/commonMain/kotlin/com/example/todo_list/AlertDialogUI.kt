package com.example.todo_list

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogUI(onDismiss:() -> Unit) {

    BasicAlertDialog(
        onDismissRequest = onDismiss
    ) {
        Surface() {
            OutlinedTextField(
                state = rememberTextFieldState(),
                label = { Text("Title") }
            )
            TextButton(
                onClick = {},

            ){
                Text("Confirm")
            }
        }
    }

}