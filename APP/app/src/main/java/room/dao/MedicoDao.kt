package room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import room.Medico

@Dao
interface MedicoDao {
    @Upsert
    suspend fun addMedico(medico: Medico)

    @Delete
    suspend fun deleteMedico(medico: Medico)

    @Query("SELECT * FROM tabela_medico ORDER BY nomeMedico ASC")
    fun getMedicoOrderByMedico(): Flow<List<Medico>>
}