class Libro(
    id: String,
    titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE
) : ElementoBiblioteca(id, titulo, estado), Prestable {
    override fun prestar() {
        if (estado == EstadoElemento.DISPONIBLE) {
            estado = EstadoElemento.PRESTADO
            GestorMensajes.log("Libro prestado: $titulo")
        } else {
            GestorMensajes.error("El libro $titulo no está disponible para préstamo.")
        }
    }

    override fun devolver() {
        if (estado == EstadoElemento.PRESTADO) {
            estado = EstadoElemento.DISPONIBLE
            GestorMensajes.log("Libro devuelto: $titulo")
        } else {
            GestorMensajes.error("El libro $titulo no estaba en préstamo.")
        }
    }

    init {
        require(titulo.isNotEmpty()) { "El libro debe tener titulo" }
        require(autor.isNotEmpty()) { "El libro debe tener autor" }
        require(anioPublicacion > 0) { "El año de publicación debe ser mayor a 0" }
        require(tematica.isNotEmpty()) { "El libro debe tener tematica" }
    }
}