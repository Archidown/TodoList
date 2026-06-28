package com.example.todo_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetItem(onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    val titleState = rememberTextFieldState()
    val descriptionState = rememberTextFieldState()
    var showSheet by remember { mutableStateOf(false) }
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = Modifier.fillMaxSize(),
        dragHandle = null

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
                label = { Text("title") },
                placeholder = { Text("Insert Title") },
                textStyle = LocalTextStyle.current.copy(fontSize = 70.sp)
            )
            OutlinedTextField(
                state = descriptionState,
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("title") },
            )
            Button(
                onClick = {showSheet=true}
            ) { Text("Date") }
            if (showSheet){
                LaunchedEffect(Unit){
                    sheetState.hide()
                }
                ModalBottomSheetDatePicker(onDismiss = {showSheet=false})
            }
            else{
                LaunchedEffect(Unit){
                    sheetState.show()
                }
            }
        }
    }

}

