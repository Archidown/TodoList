package com.example.todo_list

data class Task(
    val id:Long,
    val title: String,
    val isDone: Boolean=false
)
