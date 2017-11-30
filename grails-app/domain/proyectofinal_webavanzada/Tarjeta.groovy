package proyectofinal_webavanzada

import seguridad.Usuario

class Tarjeta {
    static belongsTo = [usuario:Usuario]
    static hasMany = [cartItems:DetalleTarjeta]

    static constraints = {
    }
}
