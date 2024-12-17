package room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tabela_feto")
data class Feto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nomeFeto: String,
    val dataNascimentoFeto: LocalDate,
    val pesoFeto: String,
    val alturaFeto: String,
    val circunferenciaCabecaFeto: String,
    val idadeEmMesesFeto: Int
)