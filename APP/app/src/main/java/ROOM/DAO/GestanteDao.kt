package ROOM.DAO

import ROOM.Gestante
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface GestanteDao {
    @Insert
    fun addGestante(gestante: Gestante)
    @Delete
    fun deleteGestante(gestante: Gestante)
}