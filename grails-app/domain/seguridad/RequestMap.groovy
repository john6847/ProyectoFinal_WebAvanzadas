package seguridad

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.http.HttpMethod

@GrailsCompileStatic
@EqualsAndHashCode(includes=['configAttribute', 'httpMethod', 'url'])
@ToString(includes=['configAttribute', 'httpMethod', 'url'], cache=true, includeNames=true, includePackage=false)
class RequestMap implements Serializable{

    private static final long serialVersionUID = 1

    String configAttribute
    HttpMethod httpMethod
    String url

    static constraints = {
        configAttribute nullable: false, blank: false
        httpMethod nullable: true
        url nullable: false, blank: false, unique: 'httpMethod'
    }

    static mapping = {
        table 'seguridad_requestmap'
        cache true
    }
}