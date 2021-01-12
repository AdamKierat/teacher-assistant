package com.example.teacherassistant.model

import SubjectDao
import SubjectGroupDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teacher_app.model.mark.MarkDao
import com.example.teacher_app.model.student.Student
import com.example.teacher_app.model.student.StudentDao
import com.example.teacher_app.model.subject.Subject
import com.example.teacher_app.model.subjectGroup.SubjectGroup
import com.example.teacherassistant.model.Mark.Mark


@Database(
    entities = [
        Mark::class,
        Student::class,
        Subject::class,
        SubjectGroup::class
    ],
    version = 3,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun markDao(): MarkDao
    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
    abstract fun subjectGroupDao(): SubjectGroupDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}