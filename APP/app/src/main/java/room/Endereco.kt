package room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_endereco")
data class Endereco(
    val endereco: String,
    val complemento: String,
    val CEP: String,
    @PrimaryKey(autoGenerate = true)
    val idEndereco: Int
)
