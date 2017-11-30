package proyectofinal_webavanzada

import seguridad.Perfil
import seguridad.RequestMap
import seguridad.Usuario
import seguridad.UsuarioPerfil

class BootStrap {

    def init = { servletContext ->

        Usuario usuario =Usuario.findByUsername("admin") ? null :new Usuario(apellido: "N/A",username: "admin", password: "admin", nombre: "Administrador",nombreCompleto: "John Jerry",email: "bencosky5@gmail.com",direccion: "Valle verde").save(flush: true, failOnError: true)
        if(usuario) {

            Perfil perfil = new Perfil(authority: "ROLE_ADMIN").save(flush: true, failOnError: true)

            UsuarioPerfil.create(usuario, perfil)

            new Perfil(authority: "ROLE_USUARIO").save(flush: true, failOnError: true)

            for (String url in [
                    '/', '/error', '/index', '/index.gsp', '/**/favicon.ico', '/shutdown',
                    '/assets/**', '/**/js/**', '/**/css/**', '/**/images/**',
                    '/login', '/login.*', '/login/*',
                    '/logout', '/logout.*', '/logout/*', '/dbconsole/**']) {
                new RequestMap(url: url, configAttribute: 'permitAll,ROLE_ANONYMOUS').save(flush: true, failOnError: true)
            }


            new RequestMap(url: '/console/**', configAttribute: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            new RequestMap(url: '/plugins/console*/**', configAttribute: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            new RequestMap(url: '/static/console/**', configAttribute: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            new RequestMap(url: '/profile/**', configAttribute: 'ROLE_USER').save(flush: true, failOnError: true)
            new RequestMap(url: '/admin/**', configAttribute: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            new RequestMap(url: '/admin/role/**', configAttribute: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            new RequestMap(url: '/admin/user/**', configAttribute: 'ROLE_ADMIN').save(flush: true, failOnError: true)
            new RequestMap(url: '/login/impersonate', configAttribute: 'ROLE_SWITCH_USER,isFullyAuthenticated()').save(flush: true, failOnError: true)
        }

    }
    def destroy = {
    }
}
