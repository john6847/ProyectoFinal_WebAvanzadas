package proyectofinal_webavanzada

class ItemEnVenta {
    Integer cantidad
    BigInteger cantidadTotal

    static belongsTo = [venta:Venta,producto:Producto]

    static constraints = {
    }
}
