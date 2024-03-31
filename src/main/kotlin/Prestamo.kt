import java.time.LocalDateTime

data class Prestamo(val usuario: Usuario, val libro: Libro, val fechaPrestamo: String = LocalDateTime.now().toString())