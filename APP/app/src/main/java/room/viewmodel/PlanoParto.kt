package room.viewmodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_plano_parto")
data class PlanoParto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val trabalhoDeParto: String,
    val duranteParto: String,
    val aposParto: String,
    val cuidadosComBebe: String
)