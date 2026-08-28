package com.example.todo_list.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_list.model.TaskDao
import com.example.todo_list.model.TaskModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class TaskViewModel(private val taskDao: TaskDao) : ViewModel() {

    val taskList = taskDao.getAllTasks().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    fun addTask(title: String, description: String, date: String) {
        viewModelScope.launch {
            val task = TaskModel(
                title = title,
                description = description,
                date = date
            )
            taskDao.addTask(task)
        }

    }

    fun checkTask(title: String, date: String): Boolean {
        return !(title == "" || date == "Date")
    }

    fun checkBoxRemoveTask(task: TaskModel) {
        viewModelScope.launch {
            taskDao.updateTask(task.copy(isDone = true))
            delay(500.milliseconds)
            taskDao.deleteTask(task)
        }
    }
}