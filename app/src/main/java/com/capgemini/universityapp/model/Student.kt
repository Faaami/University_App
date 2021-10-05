package com.capgemini.universityapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students")
data class Student (
        val firstName : String,
        val lastName : String,
        val marks : Int,
        @PrimaryKey(autoGenerate = true) val id : Int = 0)

