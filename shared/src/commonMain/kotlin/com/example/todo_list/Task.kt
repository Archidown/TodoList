package com.example.todo_list

data class Task(
    val id:Long,
    val title: String,
    val description: String,
    val date: String,
    val isDone: Boolean=false
)
