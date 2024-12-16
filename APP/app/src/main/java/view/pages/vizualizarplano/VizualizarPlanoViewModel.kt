package view.pages.vizualizarplano

class UserInput(private var name: String) {
    fun update(name: String) {
        this.name = name
    }

    fun getName(): String {
        return this.name
    }
}

