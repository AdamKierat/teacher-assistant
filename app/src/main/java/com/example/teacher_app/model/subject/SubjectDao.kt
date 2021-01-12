import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.teacher_app.model.subject.Subject

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSubject(subject: Subject)

    @Update
    suspend fun updateSubject(subject: Subject)

    @Query("SELECT * FROM subject_table ORDER BY idSubject ASC")
    fun readAllData(): LiveData<List<Subject>>

    @Query("DELETE FROM subject_table")
    suspend fun clearTable()
}