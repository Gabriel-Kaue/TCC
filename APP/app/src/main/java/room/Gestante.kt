package room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "tabela_gestante", foreignKeys = [ForeignKey(
        entity = Feto::class,
        childColumns = ["fetoId"],
        parentColumns = ["id"] // Use id aqui
    ), ForeignKey(
        entity = Endereco::class,
        childColumns = ["enderecoId"],
        parentColumns = ["idEndereco"]
    )]
)
data class Gestante(
    val racaCor: String,
    @ColumnInfo(name = "enderecoId")
    val enderecoId: Int,
    val email: String,
    val senha: String,
    val nomeAcomp: String,
    val nomeGest: String,
    val nomeProg: String,
    val numeroS: Int,
    @PrimaryKey
    val nis: Int,
    @ColumnInfo(name = "fetoId")
    val fetoId: Int,
)