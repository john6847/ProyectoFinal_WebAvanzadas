<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bienvenido...</title>

    <link rel="stylesheet " type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    %{--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--}%
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <script type="text/javascript">

        $(document).ready(function(e) {
            $('.selectpicker').selectpicker();
        });

    </script>
</head>
<body>

<!-- Horizontal Form -->
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">Crear Usuario</h3>
    </div>
    <g:form action="usuarioCrearPost">
        <div class="box-body">

            <div style="margin-bottom:5%" class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Nombre Completo</label>
                <div class="col-sm-10">
                    <input style="border: 1px solid cornflowerblue;" type="text" name="nombreCompleto" class="form-control" id="inputNombreCompleto" placeholder="entrar nombre usuario">
                </div>
            </div>

            <div style="margin-bottom:5%" class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Nombre  Usuario</label>
                <div class="col-sm-10">
                    <input style="border: 1px solid cornflowerblue;" type="text" name="username" class="form-control" id="inputEmail3" placeholder="entrar nombre usuario">
                </div>
            </div>

            <div style="margin-bottom:10%" class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Contrasena</label>
                <div class="col-sm-10">
                    <input style="border: 1px solid cornflowerblue;" type="password" name="passwordUser" class="form-control" id="inputPassword3" placeholder="contrasena">
                </div>
            </div>

            <div style="padding-top:5%" class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Rol</label>
                <div class="col-sm-10">

                    <select style="background-color: #bbbdff" name="SeleccionarRol"  id="SeleccionarRol"  class="selectpicker form-control" multiple>

                        <option value="ROLE_ADMIN">admin</option>
                        <option value="ROLE_USER">user</option>

                    </select>
                </div>
            </div>

            <div style="padding:1%" class="form-group">
                <label style="padding:1%" class="col-sm-2 control-label">Departamento Contacto</label>
                <div style="padding:1%" class="col-sm-10">
                    <select style="background-color: #bbbdff" name="SeleccionarDepartamento"  id="SeleccionarDepartamento"  class="selectpicker form-control" multiple>
                        <g:each in="${departamentos}" var="dep">
                            <option value="${dep.id}">${dep.nombre}</option>

                        </g:each>
                    </select>
                </div>
            </div>

        </div><!-- /.box-body -->
        <div class="box-footer">
            %{--<button type="submit" class="btn btn-danger">Cancel</button>--}%
            <button type="submit" class="btn btn-info pull-right">Crear</button>
        </div>
    </g:form>

</div>

</body>
</html>