package view.pages.acompanhamento

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import room.Feto
import java.time.LocalDate

class FetoViewModel : ViewModel() {
    var feto by mutableStateOf(
        Feto(
            nomeFeto = "Feto",
            dataNascimentoFeto = LocalDate.of(2024, 1, 1),
            pesoFeto = "N/A",
            alturaFeto = "N/A",
            circunferenciaCabecaFeto = "N/A",
            idadeEmMesesFeto = 0
        )
    )
        private set

    fun atualizarFeto() {
        feto = simularCrescimentoFeto(feto)
    }

    private fun simularCrescimentoFeto(fetoAtual: Feto): Feto {
        val meses = fetoAtual.idadeEmMesesFeto + 1
        val peso = calcularPesoFeto(meses)
        val altura = calcularAlturaFeto(meses)
        val circunferenciaCabeca = calcularCircunferenciaCabecaFeto(meses)
        return fetoAtual.copy(
            pesoFeto = String.format("%.1f kg", peso),
            alturaFeto = String.format("%.1f cm", altura),
            circunferenciaCabecaFeto = String.format("%.1f cm", circunferenciaCabeca),
            idadeEmMesesFeto = meses
        )
    }

    private fun calcularPesoFeto(idadeEmMeses: Int): Double {
        return 3.0 + (idadeEmMeses * 0.3)
    }

    private fun calcularAlturaFeto(idadeEmMeses: Int): Double {
        return 50.0 + (idadeEmMeses * 2.5)
    }

    private fun calcularCircunferenciaCabecaFeto(idadeEmMeses: Int): Double {
        return 34.0 + (idadeEmMeses * 0.4)
    }
}