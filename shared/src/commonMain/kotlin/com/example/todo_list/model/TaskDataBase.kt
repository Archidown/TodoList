package com.example.todo_list.model

import androidx.room3.Database
import androidx.room3.RoomDatabase


@Database(entities = [TaskModel::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}