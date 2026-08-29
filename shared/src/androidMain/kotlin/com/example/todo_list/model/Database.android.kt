package com.example.todo_list.model

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase


fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}

fun createTaskDao(context: Context): TaskDao =
    getRoomDatabase(getDatabaseBuilder(context)).taskDao()
