package com.example.teacher_app.model.student

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

class Student {
    @Parcelize
    @Entity(tableName = "student_table")
    data class Student (
        @PrimaryKey(autoGenerate = true)
        val idStudent: Int,
        val nameStudent: String,
        val surnameStudent: String
    ): Parcelable
}