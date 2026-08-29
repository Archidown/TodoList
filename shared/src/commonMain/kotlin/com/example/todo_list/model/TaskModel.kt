package com.example.todo_list.model

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class TaskModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val date: String,
    val isDone: Boolean=false
)