package view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import navigation.MainScreen
import room.AppDatabase
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import room.AppDatabase.Companion.getDatabase
import room.repository.AppRepository


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db by lazy { AppDatabase.getDatabase(this) }
        val repository by lazy { AppRepository(db.gestanteDao()) }

        setContent {
            MainScreen()
        }
    }
}

