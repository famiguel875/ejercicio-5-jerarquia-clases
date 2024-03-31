class RegistroPrestamos(private val gestorBiblioteca: GestorBiblioteca) {
    private val prestamosActuales = mutableListOf<Prestamo>()
    private val historialPrestamos = mutableListOf<Prestamo>()

    fun registrarPrestamo(usuario: Usuario, libro: Libro) {
        if (gestorBiblioteca.estaDisponible(libro.id)) {
            gestorBiblioteca.cambiarEstadoLibro(libro.id, EstadoElemento.PRESTADO)
            val prestamo = Prestamo(usuario, libro)
            prestamosActuales.add(prestamo)
            historialPrestamos.add(prestamo)
            GestorMensajes.log("Préstamo registrado: Usuario ${usuario.obtenerNombre()} ha tomado prestado el libro ${libro.titulo}.")
        } else {
            GestorMensajes.error("El libro ${libro.titulo} no está disponible para préstamo.")
        }
    }

    fun devolverLibro(libro: Libro) {
        val prestamo = prestamosActuales.find { it.libro.id == libro.id }
        if (prestamo != null) {
            gestorBiblioteca.cambiarEstadoLibro(libro.id, EstadoElemento.DISPONIBLE)
            prestamosActuales.remove(prestamo)
            GestorMensajes.log("Libro ${libro.titulo} devuelto.")
        } else {
            GestorMensajes.error("El libro ${libro.titulo} no estaba en préstamo.")
        }
    }

    fun consultarHistorialPrestamosLibro(libro: Libro) {
        val historial = historialPrestamos.filter { it.libro.id == libro.id }
        if (historial.isNotEmpty()) {
            GestorMensajes.log("Historial de préstamos para el libro ${libro.titulo}:")
            historial.forEachIndexed { index, prestamo ->
                GestorMensajes.log("${index + 1}. Usuario: ${prestamo.usuario.obtenerNombre()}, Fecha: ${prestamo.fechaPrestamo}")
            }
        } else {
            GestorMensajes.log("No hay historial de préstamos para el libro ${libro.titulo}.")
        }
    }

    fun consultarHistorialPrestamosUsuario(usuario: Usuario) {
        val historial = historialPrestamos.filter { it.usuario.obtenerId() == usuario.obtenerId() }
        if (historial.isNotEmpty()) {
            GestorMensajes.log("Historial de préstamos para el usuario ${usuario.obtenerNombre()}:")
            historial.forEachIndexed { index, prestamo ->
                GestorMensajes.log("${index + 1}. Libro: ${prestamo.libro.titulo}, Fecha: ${prestamo.fechaPrestamo}")
            }
        } else {
            GestorMensajes.log("No hay historial de préstamos para el usuario ${usuario.obtenerNombre()}.")
        }
    }
}