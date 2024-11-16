package ROOM

import ROOM.DAO.AgendaDao
import ROOM.DAO.EnderecoDao
import ROOM.DAO.FaqDao
import ROOM.DAO.FetoDao
import ROOM.DAO.GestanteDao
import ROOM.DAO.MedicoDao
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
