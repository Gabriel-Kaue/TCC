package ROOM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tabela_agenda",
    foreignKeys = [ForeignKey(
        entity = Medico::class,
        childColumns = ["crmMedico"],
        parentColumns = ["CRM"],
    )])
data class Agenda(
    @PrimaryKey
    val idAgenda: Int,
    val dataAgendamento: Date,
    @ColumnInfo(name = "crmMedico")
    val crmMedico: String,
    @ColumnInfo(name = "nisGestante")
    val nisGestante:String,
    )
