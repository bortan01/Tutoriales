<?php
$titulo = 'REGISTRO';
include_once './Conexion.inc.php';
include_once './RepositorioUsuario.inc.php';
include_once './Usuario.inc.php';
include_once '../plantilla/documento-declaracion.inc.php';
include_once './ValidadorRegistro.inc.php';
if (isset($_POST['enviar'])) {
    
    Conexion::abrir_conexion();
    $validador = new ValidadorRegistro($_POST['nombre'], $_POST['email'], $_POST['clave1'], $_POST['clave2'],  Conexion::obtener_conexion());
    if ($validador->registro_valido()) {

        $usuario = new Usuario('', $validador->obtener_nombre(), $validador->obtener_email(), $validador->obtener_clave(), '', '');
        $usuario_insertado = RepositorioUsuario::insertar_usuario(Conexion::obtener_conexion(), $usuario);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if ($usuario_insertado) {
            //redirigir a login
        }
    }
    Conexion::cerrar_conexion();
}


include '../plantilla/barra.inc.php';
?>
<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">FORMULARIO DE REGISTRO</h1>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-6 text-center">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">INSTRUCCIONES</h3>                  

                </div>
                <div class="panel-body"><br>
                    <p class="text-justify">
                        PARA UNIRTE AL BLOG INTRODUCE UN NOMBRE DE
                        USUARIO UN EMAIL Y UNA CONTRASENIA QUE 
                        SEAN REALES 
                    </p>
                    <br>
                    <a href="#">ya tienes cuenta?</a>
                    <br><br>
                    <a href="#">olvidaste tu contrasenia</a>
                </div>
            </div>
        </div>
        <div class="col-md-6 text-center" >
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">INTRODUCE TUS DATOS </h3>                  
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
<?php
if (isset($_POST['enviar'])) {
    include_once '../plantilla/registro_validado.inc.php';
} else {
    include_once '../plantilla/registro_vacio.inc.php';
}
?>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<?php
include_once '../plantilla/documento-cierre.inc.php';
?>