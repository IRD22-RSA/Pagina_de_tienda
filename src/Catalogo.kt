class Catalogo (var nombre: String, var id: Int, var productos: Productos)
{
    val listaCatalogo: String
        get() = productos.nombre
}