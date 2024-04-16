class Controlador {
    private val admin = Admin()
    fun showMenu() {
        while (true) {
            println(
                """
            Selecciona una opción:
            1. Menu clientes
            2. Menú producto
            3. Crear venta
            4. Ver ventas
            5.menu proveedor
            6.Mostrar todo
            7.Salir
        """
            )
            when (readlnOrNull()?.toInt()) {
                1 -> {
                    println(
                        """
                    1. Agregar cliente
                    2. Eliminar cliente
                    3. Modificar cliente
                    4. Ver lista de clientes
                    """
                    )
                    when (readlnOrNull()?.toInt()) {
                        1 -> {
                            println("Ingrese el nombre del cliente:")
                            val nombre = readln()
                            println("Ingrese el ID del cliente:")
                            val id = readln().toInt()
                            println("Ingrese la dirceción del cliente:")
                            val direcion = readln()
                            admin.agregarCliente(Cliente(nombre, id, direcion))
                        }

                        2 -> {
                            println("Ingrese el ID del cliente a eliminar:")
                            val id = readln().toInt()
                            admin.eliminarCliente(id)
                        }

                        3 -> {
                            println("Ingrese el ID del cliente a modificar:")
                            val id = readln().toInt()
                            println("Ingrese el nuevo nombre del cliente:")
                            val nuevoNombre = readln()
                            admin.modificarCliente(id, nuevoNombre)
                        }

                        4 -> {
                            println("Lista de clientes:")
                            admin.clientes.forEach { println("ID: ${it.id}, Nombre: ${it.nombre}, Direción: ${it.direcion}") }
                        }
                    }
                }

                2 -> {
                    println(
                        """
                    1. Agregar Producto
                    2. Eliminar Producto
                    3. Modificar Producto
                    4. Ver lista de Productos
                    """
                    )
                    when (readlnOrNull()?.toInt()) {
                        1 -> {
                            println("Ingrese el id del Producto:")
                            val id = readln().toInt()
                            println("Ingrese el nombre del Producto:")
                            val nombre = readln()
                            println("Ingrese el precio del Producto:")
                            val precio = readln().toDouble()
                            admin.agregarProducto(Productos(id, nombre, precio))
                        }

                        2 -> {
                            println("Ingrese el id del Producto a eliminar:")
                            val id = readln().toInt()
                            admin.eliminarProducto(id)
                        }

                        3 -> {
                            println("Ingrese el id del Producto a modificar:")
                            val id = readln().toInt()
                            println("Ingrese el nuevo nombre del Producto:")
                            val nombre = readln()
                            println("Ingrese el nuevo precio del Producto:")
                            val precio = readln().toDouble()
                            admin.modificarProducto(id, nombre, precio)
                        }

                        4 -> {
                            println("Lista de Productos:")
                            admin.productos.forEach { println("id: ${it.id}, Nombre: ${it.nombre}, Precio : ${it.precio}") }
                        }
                    }
                }

                3 -> {
                    println("Ingrese el ID del cliente para la venta:")
                    val idCliente = readln().toInt()
                    println("Ingrese el id del producto para la venta:")
                    val idProducto = readln().toInt()
                    println("Ingrese la cantidad del producto para la venta:")
                    val precio = readln().toInt()
                    admin.crearVenta(idCliente, idProducto, precio)
                }

                4 -> {
                    println("Lista de ventas:")

                    admin.ventas.forEach { reserva ->
                        println("Cliente: ${reserva.cliente.nombre}, Producto: ${reserva.productos.nombre}, cantidad: ${reserva.cantidad}, Total a pagar: ${reserva.totalAPagar}")
                    }
                }

                5 -> {
                    println(
                        """
                    1. Agregar proveedor
                    2. Eliminar proveedor
                    3. Modificar proveedor
                    4. Ver lista de proveedores
                    """
                    )
                    when (readlnOrNull()?.toInt()) {
                        1 -> {
                            println("Ingrese el nombre del proveedor:")
                            val nombre = readln()
                            println("Ingrese el ID del proveedor:")
                            val id = readln().toInt()
                            admin.agregarProveedor(Proveedor(nombre, id))
                        }

                        2 -> {
                            println("Ingrese el ID del proveedor a eliminar:")
                            val id = readln().toInt()
                            admin.eliminarProveedor(id)
                        }

                        3 -> {
                            println("Ingrese el ID del proveedor a modificar:")
                            val id = readln().toInt()
                            println("Ingrese el nuevo nombre del proveedor:")
                            val nuevoNombre = readln()
                            admin.modificarProveedor(id, nuevoNombre)
                        }

                        4 -> {
                            println("Lista de proveedores:")
                            admin.proveedores.forEach { println("ID: ${it.id}, Nombre: ${it.nombre}") }
                        }
                    }
                }

                6 -> {
                    println("Clientes:")
                    admin.clientes.forEach {
                        println("ID: ${it.id}, Nombre: ${it.nombre}, Direción: ${it.direcion}")
                    }
                    println("Productos:")
                    admin.productos.forEach { println("id: ${it.id}, Nombre: ${it.nombre}, Precio : ${it.precio}") }
                    println("Ventas:")
                    admin.ventas.forEach { reserva ->
                        println("Cliente: ${reserva.cliente.nombre}, Producto: ${reserva.productos.nombre}, cantidad: ${reserva.cantidad}, Total a pagar: ${reserva.totalAPagar}")
                    }
                }

                7 -> return

                else -> println("Opción no válida. Por favor, intente de nuevo.")

            }
        }
    }
}


