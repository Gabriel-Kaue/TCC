package room

import android.content.Context
import room.dao.AgendaDao
import room.dao.EnderecoDao
import room.dao.FaqDao
import room.dao.FetoDao
import room.dao.GestanteDao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Gestante::class, Agenda::class, Endereco::class, Feto::class, Faq::class],
    version = 1
)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun gestanteDao(): GestanteDao
    abstract fun agendaDao(): AgendaDao
    abstract fun fetoDao(): FetoDao
    abstract fun faqDao(): FaqDao
    abstract fun enderecoDao(): EnderecoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

