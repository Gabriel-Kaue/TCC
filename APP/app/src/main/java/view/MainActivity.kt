package view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import navigation.MainScreen
import room.AppDatabase
import androidx.room.Room


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
//        val dp = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "appgest"
//        ).build()
    }
}

