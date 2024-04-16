class Venta  (var cliente: Cliente, var productos: Productos, var cantidad: Int)
{
    val totalAPagar: Double
        get() = productos.precio * cantidad
}
