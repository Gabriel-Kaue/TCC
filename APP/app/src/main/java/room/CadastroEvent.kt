package room

sealed interface CadastroEvent {
    object SalvarGestante : CadastroEvent
    data class SetNomeGest(val nomeGest: String) : CadastroEvent
    data class SetEmail(val email: String) : CadastroEvent
    data class SetSenha(val senha: String) : CadastroEvent
}
