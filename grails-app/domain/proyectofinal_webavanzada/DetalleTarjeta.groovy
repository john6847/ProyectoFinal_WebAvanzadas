package proyectofinal_webavanzada

class DetalleTarjeta {
    BigInteger cantidadItem
    BigInteger cantidadTotal

    static belongsTo = [tarjeta:Tarjeta,producto:Producto]

    static constraints = {
    }
}
