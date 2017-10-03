<div class="form-group">
    <label>nombre de usuario</label>
    <input type="text" class="form-control" name="nombre" placeholder="desarrollador novato" <?php $vali ?>>
    <?php
    $validador->mostrar_error_nombre();
    ?>
</div>
<div class="form-group">
    <label>email</label>
    <input type="email" class="form-control" name="email" placeholder="usuario@aa.com" <?php $validador->mostrar_email() ?>>
    <?php
    $validador->mostrar_error_email();
    ?>
</div>
<div class="form-group">
    <label>password</label>
    <input type="password" class="form-control" name="clave1" placeholder="***********">
    <?php
    $validador->mostrar_error_clave1();
    ?>
</div>
<div class="form-group">
    <label>repite la password</label>
    <input type="password" class="form-control" name="clave2" placeholder="***********">
    <?php
    $validador->mostrar_error_clave2();
    ?>
</div>
<br>
<button type="submit" class="btn btn-default btn-primary" name="enviar">ENVIAR DATOS</button>
<button type="reset" class="btn btn-default btn-primary">LIMPIAR DATOS</button>
