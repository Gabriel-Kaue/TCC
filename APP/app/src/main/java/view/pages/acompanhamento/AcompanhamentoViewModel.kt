package view.pages.acompanhamento

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Random

class AcompanhamentoViewModel : ViewModel() {

    var name by mutableStateOf("Baby")
        private set
    var birthDate by mutableStateOf("01/01/2024")
        private set
    var weight by mutableStateOf("N/A")
        private set
    var height by mutableStateOf("N/A")
        private set
    var headCircumference by mutableStateOf("N/A")
        private set


    private fun generateRandomValues() {
        val random = Random()
        name = "Baby ${random.nextInt(100)}"
        weight = "${random.nextDouble() * 5 + 2} kg"
        height = "${random.nextInt(20) + 50} cm"
        headCircumference = "${random.nextInt(10) + 30} cm"
    }

    fun updateBabyData() {
        generateRandomValues()
    }
}