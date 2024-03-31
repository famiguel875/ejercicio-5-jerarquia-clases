abstract class ElementoBiblioteca(
    val id: String,
    val titulo: String,
    var estado: EstadoElemento = EstadoElemento.DISPONIBLE
)