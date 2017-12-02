package proyectofinal_webavanzada

class Producto {

    BigInteger cantidad_disponible
    BigInteger precio
    String imagenProducto
    String nombre
    String descripcion

    static hasMany = [itemesEnVenta:ItemEnVenta]
    static constraints = {
    }
}
