package room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import room.AppDatabase
import room.Gestante
import room.repository.AppRepository

class GestanteViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Gestante>>
    private val repository: AppRepository

    init {
        val gestanteDao = AppDatabase.getDatabase(application).gestanteDao()
        repository = AppRepository(gestanteDao)
        readAllData = repository.readAllData
    }
}