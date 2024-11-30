package room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import room.Feto

@Dao
interface FetoDao {
    @Upsert
    suspend fun addFeto(feto: Feto)

    @Delete
    suspend fun deleteFeto(feto: Feto)

    @Query("SELECT * FROM tabela_feto ORDER BY idFeto ASC")
    fun getFetoOrderByFeto(): Flow<List<Feto>>
}