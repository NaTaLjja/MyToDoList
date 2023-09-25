package com.example.hw_db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase :RoomDatabase(){
    abstract fun taskDao():TaskDao
}