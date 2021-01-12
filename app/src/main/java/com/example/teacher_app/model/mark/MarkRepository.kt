package com.example.teacher_app.model.mark

import com.example.teacherassistant.model.Mark.Mark
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarkRepository(private val markDao: MarkDao) {

    fun readAllData(id:Int) = markDao.readAllData(id)

    suspend fun addMark(mark: Mark){
        markDao.addMark(mark)
    }

    suspend fun updateStudent(mark: Mark) {
        markDao.updateMark(mark)
    }

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
            markDao.clearTable()
        }
    }
}