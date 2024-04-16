class Admin {
    var clientes = mutableListOf<Cliente>()
    var productos = mutableListOf<Productos>()
    var ventas = mutableListOf<Venta>()
    var proveedores = mutableListOf<Proveedor>()

    fun agregarCliente(cliente: Cliente) {
        clientes.add(cliente)
    }

    fun eliminarCliente(id: Int) {
        clientes.removeIf { it.id == id }
    }

    fun modificarCliente(id: Int, nuevoNombre: String) {
        clientes.find { it.id == id }?.nombre = nuevoNombre
    }

    fun agregarProducto(producto: Productos) {
        productos.add(producto)
    }

    fun eliminarProducto(id: Int) {
        productos.removeIf { it.id == id }
    }

    fun modificarProducto(id: Int, nuevoNombre: String, nuevoPrecio: Double) {
        productos.find { it.id == id }?.apply {
            nombre = nuevoNombre
            precio = nuevoPrecio
        }
    }

    fun crearVenta(idCliente: Int, idProducto: Int, precio: Int): Venta? {
        val cliente = clientes.find { it.id == idCliente }
        val producto = productos.find { it.id == idProducto }
        return if (cliente != null && producto != null) {
            val venta = Venta(cliente, producto, precio)
            ventas.add(venta)
            venta
        } else {
            null
        }
    }
    fun agregarProveedor(proveedor: Proveedor) {
        proveedores.add(proveedor)
    }

    fun eliminarProveedor(id: Int) {
        proveedores.removeIf { it.id == id }
    }

    fun modificarProveedor(id: Int, nuevoNombre: String) {
        proveedores.find { it.id == id }?.nombre = nuevoNombre
    }
}
