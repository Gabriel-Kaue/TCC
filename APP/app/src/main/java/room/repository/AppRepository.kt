package room.repository

import androidx.lifecycle.LiveData
import room.Gestante
import room.dao.GestanteDao

class AppRepository(private val gestanteDao: GestanteDao) {
    val readAllData: LiveData<List<Gestante>> = gestanteDao.getAll()
    suspend fun addGestante(gestante: Gestante) {
        gestanteDao.addGestante(gestante)

    }
}