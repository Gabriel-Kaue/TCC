package ROOM
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gestante_table")
data class Gestante(
    val racaCor: String,
    val CEP: String,
    val email: String,
    val nomeAcomp: String,
    val nomeGest: String,
    val nomeProg:String,
    val numeroS: Int,
    @PrimaryKey
    val nis: Int,
    val idBebe: Int,
)
