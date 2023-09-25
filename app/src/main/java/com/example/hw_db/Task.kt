package com.example.hw_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "task")
data class Task(@PrimaryKey (autoGenerate = true)val id:Int? = null, val title: String, val description:String)

