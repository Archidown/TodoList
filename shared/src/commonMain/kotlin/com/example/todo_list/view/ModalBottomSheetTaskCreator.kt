package com.example.todo_list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_list.view.icons.date_range
import com.example.todo_list.view.themes.Accent
import com.example.todo_list.view.themes.OnAccent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetItem(onDismiss: () -> Unit, onAddTask: (String, String, String) -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    val titleState = rememberTextFieldState()
    val descriptionState = rememberTextFieldState()
    var dateText by remember { mutableStateOf("Date") }
    var showSheet by remember { mutableStateOf(false) }
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        dragHandle = null,
        containerColor = MaterialTheme.colorScheme.background

    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                state = titleState,
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("title", fontSize = 30.sp) },
                textStyle = LocalTextStyle.current.copy(fontSize = 30.sp),
                colors = taskCreatorTextFieldColors()
            )
            OutlinedTextField(
                state = descriptionState,
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("description") },
                colors = taskCreatorTextFieldColors()
            )
            Spacer(Modifier.padding(bottom = 10.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Button(
                    onClick = { showSheet = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Accent,
                        contentColor = OnAccent
                    )
                ) {
                    Icon(imageVector = date_range, contentDescription = "dateIcon")
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(dateText)
                }
                Button(
                    onClick = {
                        onAddTask(
                            titleState.text.toString(),
                            descriptionState.text.toString(),
                            dateText
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Accent,
                        contentColor = OnAccent
                    )
                ) {
                    Text("Create")
                }
            }
            if (showSheet) {
                LaunchedEffect(Unit) {
                    sheetState.hide()
                }
                ModalBottomSheetDatePicker(
                    onDismiss = { showSheet = false },
                    onDatePicked = { date ->
                        dateText = date
                    })
            } else {
                LaunchedEffect(Unit) {
                    sheetState.show()
                }
            }
        }
    }

}

@Composable
fun taskCreatorTextFieldColors(): TextFieldColors {
    val textFieldColor= OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent,
        focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
        cursorColor = MaterialTheme.colorScheme.onPrimary,
    )
    return textFieldColor
}


