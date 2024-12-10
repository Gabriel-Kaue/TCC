package view.pages.login

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import model.Credentials
import room.dao.GestanteDao


data class LoginState(
    val success: Boolean = false
)

class LoginViewModel : ViewModel() {

    val state: StateFlow<LoginState> get() = _state
    private val _state = MutableStateFlow<LoginState>(LoginState())

    fun checkCredentials(creds: Credentials, context: Context) {
        if (creds.isNotEmpty() && creds.login == "admin") {
            _state.update { state -> state.copy(success = true) }
        } else {
            _state.update { state -> state.copy(success = false) }
        }
    }

}