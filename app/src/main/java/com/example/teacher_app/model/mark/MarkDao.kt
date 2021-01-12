package com.example.teacher_app.model.mark

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacherassistant.model.Mark.Mark

@Dao
interface MarkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMark(mark: Mark)

    @Query("SELECT * FROM mark_table WHERE idSubject = :idSubject")
    fun readAllData(idSubject: Int): LiveData<List<Mark>>

    @Update
    suspend fun updateMark(mark: Mark)

    @Query("DELETE FROM mark_table")
    suspend fun clearTable()
}