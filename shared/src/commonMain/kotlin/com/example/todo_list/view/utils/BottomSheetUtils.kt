package com.example.todo_list.view.utils

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dismissWithAnimation(
    sheetState: SheetState,
    onDismiss: () -> Unit
): () -> Unit {
    val scope = rememberCoroutineScope()
    return {
        scope.launch {
            sheetState.hide()
            onDismiss()
        }
    }
}