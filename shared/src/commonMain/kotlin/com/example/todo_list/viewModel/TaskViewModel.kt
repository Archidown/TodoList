package com.example.todo_list.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_list.model.TaskModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class TaskViewModel : ViewModel() {
    private val _taskList = MutableStateFlow(emptyList<TaskModel>())
    val taskList: StateFlow<List<TaskModel>> = _taskList.asStateFlow()
    fun addTask(title: String, description: String, date: String) {
        _taskList.value += TaskModel(
            id = (_taskList.value.maxOfOrNull { it.id } ?: 0) + 1,
            title = title,
            description = description,
            date = date
        )
    }

    fun removeTask(task: TaskModel) {
        _taskList.value = _taskList.value.filter { it.id != task.id }
    }

    fun checkTask(title: String, date: String): Boolean {
        return !(title == "" || date == "Date")
    }

    fun checkBoxRemoveTask(task: TaskModel) {
        viewModelScope.launch {
            _taskList.value=_taskList.value.map{
                if (it.id==task.id)
                    it.copy(isDone = true)
                else
                    it
            }
            delay(500.milliseconds)
            removeTask(task)
        }
    }
}