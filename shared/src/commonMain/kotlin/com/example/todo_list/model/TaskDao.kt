package com.example.todo_list.model

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun addTask(task: TaskModel)

    @Delete
    suspend fun deleteTask(task: TaskModel)

    @Query("SELECT * FROM TaskModel")
    fun getAllTasks(): Flow<List<TaskModel>>

    @Update
    suspend fun updateTask(task: TaskModel)
}