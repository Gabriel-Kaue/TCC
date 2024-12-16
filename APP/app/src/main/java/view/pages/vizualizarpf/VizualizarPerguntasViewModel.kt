package view.pages.vizualizarpf


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


data class FAQItem(val question: String, val answer: String)

class FAQViewModel : ViewModel() {

    // Lista de perguntas e respostas
    private val _faqList = MutableStateFlow(
        listOf(
            FAQItem(
                "Quais são os principais indicativos de gravidez?",
                "Os principais sintomas incluem atraso menstrual, náuseas, cansaço, aumento da sensibilidade nos seios, alterações no apetite e micção frequente."
            ),
            FAQItem(
                "Quando o teste de gravidez deve ser feito?",
                "O teste de gravidez deve ser feito após o atraso menstrual, normalmente cerca de 1 a 2 semanas após a data esperada da menstruação."
            ),
            FAQItem(
                "Quanto tempo dura a gestação?",
                "A gestação dura em média 40 semanas (cerca de 9 meses), contando a partir do primeiro dia do último ciclo menstrual."
            ),
            FAQItem(
                "Quando é possível descobrir o sexo do bebê?",
                "O sexo do bebê pode ser identificado a partir da oitava semana, pelo exame de sexagem fetal, e por meio de ultrassonografia entre a 12ª e 20ª semana de gestação, e mais precisamente a partir da 16ª semana."
            ),
            FAQItem(
                "Além do enjoo, quais outros incômodos são comuns na gravidez?",
                "Outros incômodos incluem dor nas costas, constipação, cansaço, inchaço nos pés e pernas, e mudanças no humor."
            ),
            FAQItem(
                "Quando a barriga começa a aparecer?",
                "A barriga pode começar a aparecer a partir da 12ª semana de gestação, mas isso pode variar dependendo da constituição física da mulher."
            ),
            FAQItem(
                "Quais alimentos são recomendados e quais devem ser evitados?",
                "Recomendados: Frutas, verduras, legumes, carnes magras, ovos, feijão, e alimentos ricos em ácido fólico como espinafre e abacate.\n" +
                        "Evitados: Alimentos crus ou mal cozidos (como carne e ovos), queijo não pasteurizado, cafeína excessiva, bebidas alcoólicas e alimentos ricos em mercúrio (como peixe de grande porte)."
            ),
            FAQItem(
                "A partir de quando o leite começa a ser produzido?",
                "O leite começa a ser produzido de forma mais intensa após a 16ª semana, mas pode ser percebido em pequenas quantidades a partir do segundo trimestre."
            )
        )
    )


    val faqList: StateFlow<List<FAQItem>> = _faqList
}




