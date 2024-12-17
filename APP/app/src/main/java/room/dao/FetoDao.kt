package room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import room.Feto

@Dao
interface FetoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(feto: Feto)

    @Query("SELECT * FROM tabela_feto")
    fun getAllFetos(): Flow<List<Feto>>
}