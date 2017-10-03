<?php
include_once './RepositorioUsuario.inc.php';
class ValidadorRegistro {

    private $error_nombre;
    private $error_email;
    private $error_clave1;
    private $error_clave2;
    private $nombre;
    private $email;
    private $aviso_inicio;
    private $aviso_cierre;
    private $clave ;

    public function __construct($nombre, $email, $clave1, $clave2, $conexion) {
        $this->aviso_inicio = "<br><div class='alert alert-danger' role='alert'>";
        $this->aviso_cierre = "</div>";
      $this ->clave ='';
        $this->nombre = '';
        $this->email = '';
             $this->error_nombre = $this->validar_nombre($nombre, $conexion);
        $this->error_email = $this->validar_email($email,$conexion);
        $this->error_clave1 = $this->validar_clave1($clave1);
        $this->error_clave2 = $this->validar_clave2($clave1, $clave2);
        if ($this -> error_clave1 === '' && $this ->error_clave2 ==='') {
            $this -> clave = $clave1;
        }
    }

    private function variable_iniciada($variable) {
        if (isset($variable) && !empty($variable)) {
            return true;
        } else {
            return false;
        }
    }

    private function validar_nombre($nombre, $conexion) {
        if (!$this->variable_iniciada($nombre)) {
            return "Debes incluir un nombre de usuario";
        } else {
            $this->nombre = $nombre;
        }
        if (strlen($nombre) < 6) {
            return 'el nombre debe ser mayor de 6 caracteres';
        }
        if (strlen($nombre) > 24) {
            return 'el nombre no debe ser mayor de 24 caracteres';
        }
        if (RepositorioUsuario::nombre_existe($conexion, $nombre)) {
            return "Este nombre de usuario ya esta en uso favor provar otro nombre";
        }
        return "";
    }

    private function validar_email($email, $conexion) {
        if (!$this->variable_iniciada($email)) {
            return 'debes proporcionar un email';
        } else {
            $this->email = $email;
        }
        if (RepositorioUsuario::email_existe($conexion, $email)) {
            return "este email ya esta en uso por favor pruevo otro email o <a href='#'>intente recupearar su contraseña</a>";
        }
        return '';
    }

    private function validar_clave1($clave1) {
        if (!$this->variable_iniciada($clave1)) {
            return 'debes escribir una  password';
        }return '';
    }

    private function validar_clave2($clave1, $clave2) {
        if (!$this->variable_iniciada($clave1)) {
            return 'rellena el campo de arriba';
        }

        if (!$this->variable_iniciada($clave2)) {
            return 'debes repetir tu password';
        }
        if ($clave1 != $clave2) {
            return 'ambas password debeb coincidir';
        }
        return '';
    }

    function obtener_nombre() {
        return $this->nombre;
    }

    function obtener_email() {
        return $this->email;
    }
    
    function obtener_clave() {
        return $this->clave;
    }

    function obtener_error_nombre() {
        return $this->error_nombre;
    }

    function obtener_error_email() {
        return $this->error_email;
    }

    function obtener_error_clave1() {
        return $this->error_clave1;
    }

    function obtener_error_clave2() {
        return $this->error_clave2;
    }

    function setError_nombre($error_nombre) {
        $this->error_nombre = $error_nombre;
    }

    function setError_email($error_email) {
        $this->error_email = $error_email;
    }

    function setError_clave1($error_clave1) {
        $this->error_clave1 = $error_clave1;
    }

    function setError_clave2($error_clave2) {
        $this->error_clave2 = $error_clave2;
    }

    function setNombre($nombre) {
        $this->nombre = $nombre;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    public function mostrar_nombre() {
        if ($this->nombre != "") {
            echo 'value = "' . $this->nombre . '"';
        }
    }

    public function mostrar_email() {
        if ($this->email != "") {
            echo 'value = "' . $this->email . '"';
        }
    }

    public function mostrar_error_nombre() {
        if ($this->error_nombre != "") {
            echo $this->aviso_inicio . $this->error_nombre . $this->aviso_cierre;
        }
    }

    public function mostrar_error_email() {
        if ($this->error_email != "") {
            echo $this->aviso_inicio . $this->error_email . $this->aviso_cierre;
        }
    }

    public function mostrar_error_clave1() {
        if ($this->error_clave1 != "") {
            echo $this->aviso_inicio . $this->error_clave1 . $this->aviso_cierre;
        }
    }

    public function mostrar_error_clave2() {
        if ($this->error_clave2 !== "") {
            echo $this->aviso_inicio . $this->error_clave2 . $this->aviso_cierre;
        }
    }

    public function registro_valido() {
        if ($this->error_nombre === "" &&
                $this->error_email === "" &&
                $this->error_clave1 === "" &&
                $this->error_clave2 === "") {
            return true;
        } else {
            return false;
        }
    }

}

?>