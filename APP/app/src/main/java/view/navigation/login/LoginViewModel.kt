package view.navigation.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import view.MainActivity


data class LoginState(
    val success: Boolean = false
)

class LoginViewModel : ViewModel() {

    val state: StateFlow<LoginState> get() = _state
    private val _state = MutableStateFlow<LoginState>(LoginState())

    fun checkCredentials(creds: Credentials, context: Context) {
        if (creds.isNotEmpty() && creds.login == "admin") {
            // context.startActivity(Intent(context, MainActivity::class.java))
            //(context as Activity).finish()
            _state.update { state -> state.copy(success = true) }
        } else {
            //Toast.makeText(context, "Wrong Credentials", Toast.LENGTH_SHORT).show()
            _state.update { state -> state.copy(success = false) }
        }
    }

}