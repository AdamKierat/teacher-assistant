package com.example.teacher_app.model.subjectGroup

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.teacher_app.model.student.Student
import com.example.teacher_app.model.subject.Subject

@Entity(tableName = "subjectGroup_table")
data class SubjectGroup (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Embedded
    val student: Student,
    @Embedded
    val subject: Subject
)