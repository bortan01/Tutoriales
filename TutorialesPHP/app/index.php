<?php
include_once './Conexion.inc.php';
include_once './RepositorioUsuario.inc.php';

$titulo = 'titulo algo';
include_once '../plantilla/documento-declaracion.inc.php';
include_once '../plantilla/barra.inc.php';
?>
      
        <div class="container">
            <div class="jumbotron">
                <h1>titular</h1>
                <p>esto es el parrafo</p>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="row">
                            <div class="col-md-12">
                                <h3>columna lateral 12 de 4</h3>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> busqueda
                                    </div>
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <input type="search" class="form-control" placeholder="que buscas?">
                                        </div>
                                        <button class="form-control">Buscar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <span class="glyphicon glyphicon-filter">filtro</span>
                                    </div>
                                    <div class="panel-body">

                                    </div>

                                </div>
                            </div>  
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <span class="glyphicon glyphicon-calendar" aria-hidden="true">Archivo</span>
                                    </div>
                                    <div class="panel-body">

                                    </div>

                                </div>
                            </div>  
                        </div>
                    </div>
                    <h3>columna lateral 12 de 8</h3>
                    <div class="col-md-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span class="glyphicon glyphicon-time" aria-hidden="true"></span> Archivo
                            </div>
                            <div class="panel-body">
                                <div class="form-group">

                                </div>
                                <?php
                                include_once '../app/Conexion.inc.php';
                                Conexion:: abrir_conexion();
                                Conexion:: cerrar_conexion();
                                ?>
                                <p>todavia no hay nada que mostrar </p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="container">

            <div class="starter-template"><br><br>
                <h1>Bootstrap starter template</h1>
                <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
            </div>

        </div><!-- /.container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
    <?php include_once '../plantilla/documento-cierre.inc.php';?>