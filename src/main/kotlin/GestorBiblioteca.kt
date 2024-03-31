class GestorBiblioteca(catalogo: Catalogo<Libro>) {
    private val libros = mutableListOf<Libro>()
    private val registroPrestamos = RegistroPrestamos(this)

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
        GestorMensajes.log("Libro agregado: ${libro.titulo}")
    }

    fun removerLibro(libro: Libro) {
        libros.remove(libro)
        GestorMensajes.log("Libro removido: ${libro.titulo}")
    }

    fun cambiarEstadoLibro(id: String, nuevoEstado: EstadoElemento) {
        libros.find { it.id == id }?.let {
            it.estado = nuevoEstado
            GestorMensajes.log("Estado cambiado a $nuevoEstado para el libro: ${it.titulo}")
        }
    }

    fun estaDisponible(id: String): Boolean {
        return libros.any { it.id == id && it.estado == EstadoElemento.DISPONIBLE }
    }

    fun estaPrestado(id: String): Boolean {
        return libros.any { it.id == id && it.estado == EstadoElemento.PRESTADO }
    }

    fun listarTodosLosLibros(): List<Libro> = libros

    fun listarLibrosDisponibles(): List<Libro> = libros.filter { it.estado == EstadoElemento.DISPONIBLE }

    fun listarLibrosPrestados(): List<Libro> = libros.filter { it.estado == EstadoElemento.PRESTADO }

    fun registrarPrestamo(usuario: Usuario, libro: Libro) {
        registroPrestamos.registrarPrestamo(usuario, libro)
    }

    fun devolverLibro(libro: Libro) {
        registroPrestamos.devolverLibro(libro)
    }

    fun consultarHistorialPrestamosLibro(libro: Libro) {
        registroPrestamos.consultarHistorialPrestamosLibro(libro)
    }

    fun consultarHistorialPrestamosUsuario(usuario: Usuario) {
        registroPrestamos.consultarHistorialPrestamosUsuario(usuario)
    }
}