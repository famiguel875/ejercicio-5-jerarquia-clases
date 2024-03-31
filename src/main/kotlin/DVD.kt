class DVD(
    id: String,
    titulo: String,
    val duracion: Int,
    val genero: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE
) : ElementoBiblioteca(id, titulo, estado), Prestable {
    override fun prestar() {
        if (estado == EstadoElemento.DISPONIBLE) {
            estado = EstadoElemento.PRESTADO
            GestorMensajes.log("DVD prestado: $titulo")
        } else {
            GestorMensajes.error("El DVD $titulo no está disponible para préstamo.")
        }
    }

    override fun devolver() {
        if (estado == EstadoElemento.PRESTADO) {
            estado = EstadoElemento.DISPONIBLE
            GestorMensajes.log("DVD devuelto: $titulo")
        } else {
            GestorMensajes.error("El DVD $titulo no estaba en préstamo.")
        }
    }
}