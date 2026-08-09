package com.example.todo_list.model

data class TaskModel(
    val id:Long,
    val title: String,
    val description: String,
    val date: String,
    var isDone: Boolean=false
)