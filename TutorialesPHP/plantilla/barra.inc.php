<?php
Conexion:: abrir_conexion();
$Total_usuarios = RepositorioUsuario :: obtener_numero_usuarios(Conexion::obtener_conexion());

Conexion :: cerrar_conexion();
?>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> favoritos</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-education" aria-hidden="true"></span> Autores</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> entrada</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">


                <li>
                    <a href="../registro.php">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>Usuarios: <?php
                        echo $Total_usuarios;
                        ?>
                    </a>
                </li>
                <li><a href="../registro.php"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>Iniciar sesion</a></li>
                <li><a href="../registro.php"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> registro</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav><br><br><br>