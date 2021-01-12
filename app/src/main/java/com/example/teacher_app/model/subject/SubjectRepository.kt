package com.example.teacher_app.model.subject

import SubjectDao
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SubjectRepository(private val subjectDao: SubjectDao) {

    val readAllData: LiveData<List<Subject>> = subjectDao.readAllData()

    suspend fun addSubject(subject: Subject){
        subjectDao.addSubject(subject)
    }

    suspend fun updateSubject(subject: Subject){
        subjectDao.updateSubject(subject)
    }

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
            subjectDao.clearTable()

            subjectDao.addSubject(Subject(idSubject = 1, nameSubject = "Math"))
            subjectDao.addSubject(Subject(idSubject = 2, nameSubject = "English"))
            subjectDao.addSubject(Subject(idSubject = 3, nameSubject = "Art"))
            subjectDao.addSubject(Subject(idSubject = 3, nameSubject = "Physics"))
        }
    }}