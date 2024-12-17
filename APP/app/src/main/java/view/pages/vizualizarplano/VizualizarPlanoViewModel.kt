package view.pages.vizualizarplano

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import room.AppDatabase
import room.viewmodel.PlanoParto


class PlanoPartoViewModel(private val database: AppDatabase) : ViewModel() {
    private val planoPartoDao = database.planoPartoDao()

    var trabalhoDeParto by mutableStateOf("")
        private set
    var duranteParto by mutableStateOf("")
        private set
    var aposParto by mutableStateOf("")
        private set
    var cuidadosComBebe by mutableStateOf("")
        private set

    init {
        carregarPlanoParto()
    }
    fun updateTrabalhoDeParto(value: String) {
        trabalhoDeParto = value
    }
    fun updateDuranteParto(value: String) {
        duranteParto = value
    }
    fun updateAposParto(value: String) {
        aposParto = value
    }
    fun updateCuidadosComBebe(value: String) {
        cuidadosComBebe = value
    }

    fun salvarPlanoDeParto() {
        viewModelScope.launch {
            val planoParto = PlanoParto(
                trabalhoDeParto = trabalhoDeParto,
                duranteParto = duranteParto,
                aposParto = aposParto,
                cuidadosComBebe = cuidadosComBebe
            )
            planoPartoDao.insert(planoParto)
        }
    }

    private fun carregarPlanoParto() {
        viewModelScope.launch {
            val planoParto = planoPartoDao.getAllPlanosParto()
            if (planoParto.isNotEmpty()) {
                val ultimoPlano = planoParto.last()
                trabalhoDeParto = ultimoPlano.trabalhoDeParto
                duranteParto = ultimoPlano.duranteParto
                aposParto = ultimoPlano.aposParto
                cuidadosComBebe = ultimoPlano.cuidadosComBebe
            }
        }
    }
}