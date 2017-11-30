package seguridad

import grails.rest.Resource
import proyectofinal_webavanzada.Tarjeta
import proyectofinal_webavanzada.Venta

class Usuario {

    String nombreCompleto;
    String apellido;
    String username;
    String password;
    boolean is_enity
//    String telefono;
    String direccion;
    String email;


    //Datos genericos del dominio.
    boolean habilitado = true;
    String creadoPor = "sistemas"
    String modificadoPor = "sistemas"
    Date dateCreated
    Date lastUpdated

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    boolean silenciarNotificacion=false

    static hasMany = [ventas:Venta]
    static hasOne = [cart:Tarjeta]

    Set<Perfil> getAuthorities() {
        (UsuarioPerfil.findAllByUsuario(this) as List<UsuarioPerfil>)*.perfil as Set<Perfil>
    }

    static constraints = {
        apellido(nullable: true)

        password blank: false, password: true
        username blank: false, unique: true
    }

    static mapping = {
        table 'seguridad_usuario'
        password column: '`password`'
    }

    boolean isAdmin(Usuario usuario){
        boolean respuesta=false;
        UsuarioPerfil.findAllByUsuario(usuario).each {
            if(it.perfil.authority=="ROLE_ADMIN"){
                respuesta=true;
            }
        }
        return respuesta
    }
}
