package view.pages.login

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import model.Credentials


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