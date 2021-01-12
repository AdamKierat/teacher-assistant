package com.example.teacher_app.model.student

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Query("SELECT * FROM student_table ORDER BY idStudent ASC")
    fun readAllData(): LiveData<List<Student>>

    @Query("DELETE FROM student_table")
    suspend fun clearTable()

}