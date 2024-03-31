class GestorMensajes {
    companion object {
        fun log(texto: String) {
            println("[LOG] $texto")
        }

        fun error(texto: String) {
            println("[ERROR] $texto")
        }
    }
}