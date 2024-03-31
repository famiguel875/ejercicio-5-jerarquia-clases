import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object UtilidadesBiblioteca {
    private var contadorLibros = 1 // Contador para generar identificadores únicos

    fun generarIdentificadorUnico(): String {
        // Se puede combinar la fecha y hora actual con un contador para obtener un identificador único
        val fechaHoraActual = LocalDateTime.now()
        val formato = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")
        val fechaHoraFormateada = fechaHoraActual.format(formato)
        return "L$fechaHoraFormateada${contadorLibros++}"
    }
}