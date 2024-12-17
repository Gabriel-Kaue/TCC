package room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import room.viewmodel.PlanoParto


@Dao
interface PlanoPartoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(planoParto: PlanoParto)

    @Query("SELECT * FROM tabela_plano_parto")
    suspend fun getAllPlanosParto(): List<PlanoParto>

}