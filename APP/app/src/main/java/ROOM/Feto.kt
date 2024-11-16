package ROOM

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_feto")
data class Feto(

    val peso: Float,
    val tipoSang: String,
    val glicemia: Int,
    val tamanho: Float,
    val pressArterialL: Float,
    val bfc: Int,
    @PrimaryKey(autoGenerate = true)
    val idFeto: Int
)
