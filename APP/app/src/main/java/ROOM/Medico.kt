package ROOM

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_medico")
data class Medico(
    @PrimaryKey
    val CRM: String,
    val nomeMedico: String,
    val tipo: String,
    val especialidade: String,
)
