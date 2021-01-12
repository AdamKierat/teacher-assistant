import com.example.teacher_app.model.student.StudentDao

import androidx.lifecycle.LiveData
import com.example.teacher_app.model.student.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.readAllData()

    suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
            studentDao.clearTable()
        }
    }
}