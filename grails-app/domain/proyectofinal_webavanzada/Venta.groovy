package proyectofinal_webavanzada

import seguridad.Usuario

class Venta {
    String NCF
    BigInteger total
    boolean ventaDispo
    String paypal_transaction_id=""

    Date dateCreate
    Date lastUpdated

    static belongsTo = [usuario:Usuario]
    static hasMany = [itemes:ItemEnVenta]
    static constraints = {
    }
}
