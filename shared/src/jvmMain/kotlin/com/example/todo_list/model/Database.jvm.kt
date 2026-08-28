package com.example.todo_list.model

import androidx.room3.Room
import androidx.room3.RoomDatabase
import java.io.File


fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    )
}

fun createTaskDao(): TaskDao =
    getRoomDatabase(getDatabaseBuilder()).taskDao()