class GestorElementos<T : ElementoBiblioteca> {
    private val elementos = mutableListOf<T>()

    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
        GestorMensajes.log("Elemento agregado al gestor: ${elemento.titulo}")
    }

    fun removerElementoPorId(id: String) {
        val elemento = elementos.find { it.id == id }
        elemento?.let {
            elementos.remove(it)
            GestorMensajes.log("Elemento eliminado del gestor: ${it.titulo}")
        }
    }

    fun getElementos(): List<T> {
        return elementos.toList()
    }

    fun buscarElementosPorCriterio(criterio: (T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }
}