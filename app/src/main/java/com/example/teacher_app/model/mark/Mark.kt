package com.example.teacherassistant.model.Mark

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.teacher_app.model.student.Student
import com.example.teacher_app.model.subject.Subject

@Entity(
    tableName = "mark_table"
)
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val idMark: Int,
    @Embedded
    val student: Student,
    @Embedded
    val subject: Subject,
    val note: String= "",
    val grade: Double,
    val date: String
)