
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teacher_app.model.subjectGroup.SubjectGroup

@Dao
interface SubjectGroupDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSubjectGroup(subjectGroup: SubjectGroup)

    @Query("SELECT * FROM subjectGroup_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<SubjectGroup>>

    @Query("DELETE FROM subject_table")
    suspend fun clearTable()
}