class Usuario(private val id: String, private val nombre: String) {
    private val librosPrestados = mutableListOf<Libro>()

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    fun quitarLibroPrestado(libro: Libro) {
        librosPrestados.remove(libro)
    }

    fun consultarLibrosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }

    fun obtenerId(): String {
        return id
    }

    fun obtenerNombre(): String {
        return nombre
    }
}