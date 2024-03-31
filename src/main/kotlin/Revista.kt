class Revista(
    id: String,
    titulo: String,
    val edicion: Int,
    val tematica: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE
) : ElementoBiblioteca(id, titulo, estado), Prestable {
    override fun prestar() {
        if (estado == EstadoElemento.DISPONIBLE) {
            estado = EstadoElemento.PRESTADO
            GestorMensajes.log("Revista prestada: $titulo")
        } else {
            GestorMensajes.error("La revista $titulo no está disponible para préstamo.")
        }
    }

    override fun devolver() {
        if (estado == EstadoElemento.PRESTADO) {
            estado = EstadoElemento.DISPONIBLE
            GestorMensajes.log("Revista devuelta: $titulo")
        } else {
            GestorMensajes.error("La revista $titulo no estaba en préstamo.")
        }
    }
}