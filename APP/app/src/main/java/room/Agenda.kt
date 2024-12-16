package room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "tabela_agenda",
    foreignKeys = [ForeignKey(
        entity = Gestante::class,
        childColumns = ["nisGestante"],
        parentColumns = ["nis"]
    )]
)
data class Agenda(
    @PrimaryKey(autoGenerate = true)
    val idAgenda: Int,
    //val dataAgendamento: Date,
    @ColumnInfo(name = "nisGestante")
    val nisGestante: String,
)
