package room

import room.dao.AgendaDao
import room.dao.EnderecoDao
import room.dao.FaqDao
import room.dao.FetoDao
import room.dao.GestanteDao
import room.dao.MedicoDao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Gestante::class, Medico::class, Agenda::class, Endereco::class, Feto::class, Faq::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gestanteDao(): GestanteDao
    abstract fun medicoDao(): MedicoDao
    abstract fun agendaDao(): AgendaDao
    abstract fun fetoDao(): FetoDao
    abstract fun faqDao(): FaqDao
    abstract fun enderecoDao(): EnderecoDao
}
