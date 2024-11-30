package room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import room.Agenda

@Dao
interface AgendaDao {
    @Upsert
    suspend fun addAgenda(agenda: Agenda)

    @Query("SELECT * FROM tabela_agenda ORDER BY idAgenda ASC")
    fun getAgendaOrderByAgenda(): Flow<List<Agenda>>
}