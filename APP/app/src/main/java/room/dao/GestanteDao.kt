package room.dao

import room.Gestante
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface GestanteDao {
    @Upsert
    suspend fun addGestante(gestante: Gestante)

    @Delete
    suspend fun deleteGestante(gestante: Gestante)

    @Query("SELECT * FROM tabela_gestante ORDER BY nomeGest ASC")
    fun getGestanteOrderByGest(): Flow<List<Gestante>>
}