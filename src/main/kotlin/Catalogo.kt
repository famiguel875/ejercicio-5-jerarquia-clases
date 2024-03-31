class Catalogo<T : ElementoBiblioteca>(private val gestorElementos: GestorBiblioteca) {
    fun agregarElemento(elemento: T) {
        gestorElementos.agregarElemento(elemento)
    }

    fun removerElementoPorId(id: String) {
        gestorElementos.removerElementoPorId(id)
    }

    fun getElementos(): List<T> {
        return gestorElementos.getElementos()
    }

    fun listarElementos() {
        getElementos().forEach { println(it) }
    }
}
