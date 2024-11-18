package room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "tabela_gestante", foreignKeys = [ForeignKey(
        entity = Feto::class,
        childColumns = ["idFeto"],
        parentColumns = ["feto"]
    ), ForeignKey(
        entity = Endereco::class,
        childColumns = ["idEndereco"],
        parentColumns = ["idEndereco"]
    )]
)
data class Gestante(
    val racaCor: String,
    @ColumnInfo(name = "idEndereco")
    val endereco: Int,
    val email: String,
    val senha: String,
    val nomeAcomp: String,
    val nomeGest: String,
    val nomeProg: String,
    val numeroS: Int,
    @PrimaryKey
    val nis: Int,
    @ColumnInfo(name = "idFeto")
    val feto: Int,
)
