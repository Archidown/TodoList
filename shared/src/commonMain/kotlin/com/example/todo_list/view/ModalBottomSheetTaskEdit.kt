package com.example.todo_list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_list.model.TaskModel
import com.example.todo_list.view.icons.date_range
import com.example.todo_list.view.icons.text_ad
import com.example.todo_list.view.themes.Accent
import com.example.todo_list.view.utils.dismissWithAnimation
import com.example.todo_list.view.utils.rememberHideKeyboard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetTaskEdit(
    task: TaskModel,
    onDismiss: () -> Unit,
    onSave: (title: String, description: String, date: String) -> Unit,
    onFinished: (TaskModel) -> Unit
) {
    val taskTitle = rememberTextFieldState(initialText = task.title)
    val taskDescription = rememberTextFieldState(initialText = task.description)
    var taskDate by remember { mutableStateOf(task.date) }
    var showDatePicker by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val dismissWithAnimation = dismissWithAnimation(sheetState = sheetState, onDismiss = onDismiss)


    ModalBottomSheet(
        onDismissRequest = { dismissWithAnimation() },
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        dragHandle = null,
        sheetState = sheetState

    ) {
        val hideKeyboard = rememberHideKeyboard()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    hideKeyboard()
                    dismissWithAnimation()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Accent
                )
            ) {
                Text(text = "Cancel", fontSize = 20.sp)
            }
            Button(
                onClick = {
                    hideKeyboard()
                    onSave(
                        taskTitle.text.toString(),
                        taskDescription.text.toString(),
                        taskDate
                    )
                    dismissWithAnimation()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Accent,
                    disabledContainerColor = Color.Transparent
                ),
                enabled = taskTitle.text.toString().isNotBlank()
            ) {
                Text(text = "Save", fontSize = 20.sp)
            }
        }
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .clip(shape = RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            EditRow(
                leading = {
                    Checkbox(
                        checked = task.isDone,
                        onCheckedChange = {
                            onFinished(task)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = MaterialTheme.colorScheme.outline,
                            uncheckedColor = MaterialTheme.colorScheme.outline
                        ),
                    )
                },
                content = {
                    OutlinedTextField(
                        state = taskTitle,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        ),
                        colors = taskCreatorTextFieldColors()
                    )
                }
            )

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            EditRow(
                leading = {
                    Icon(imageVector = text_ad, contentDescription = "description Icon")
                },
                content = {
                    OutlinedTextField(
                        state = taskDescription,
                        modifier = Modifier.fillMaxWidth(),
                        colors = taskCreatorTextFieldColors(),
                        placeholder = { Text("Description") }
                    )
                }
            )

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            EditRow(
                onClick = {
                    hideKeyboard()
                    showDatePicker = true
                },
                leading = {
                    Icon(imageVector = date_range, contentDescription = "date Icon")
                },
                content = {
                    Text(
                        text = taskDate,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                OutlinedTextFieldDefaults.contentPadding(),
                            ),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )

            if (showDatePicker) {
                ModalBottomSheetDatePicker(
                    onDismiss = { showDatePicker = false },
                    onDatePicked = { date ->
                        taskDate = date
                    })
            }

        }
    }
}

@Composable
private fun EditRow(
    leading: @Composable () -> Unit,
    content: @Composable () -> Unit,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(48.dp),
            contentAlignment = Alignment.Center
        ) { leading() }
        Box { content() }
    }
}