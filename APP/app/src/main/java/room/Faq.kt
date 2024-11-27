package room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faq")
data class Faq(
    @PrimaryKey(autoGenerate = true)
    val idPergunta: Int,
    val titulo: String,
    val pergunta: String,
    val resposta: String
)
