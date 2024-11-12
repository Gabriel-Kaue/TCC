package ROOM

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Gestante::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
 abstract  fun gestanteDao(): GestanteDao
}
