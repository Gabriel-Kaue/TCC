package ROOM

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_endeco")
data class Endereco(
    @PrimaryKey
    val idEndereco : Int,
    val endereco: String,
    val complemento: String,
    val CEP: String

)
