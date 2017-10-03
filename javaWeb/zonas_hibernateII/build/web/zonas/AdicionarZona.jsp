<%-- 
    Document   : zona
    Created on : 08-22-2017, 09:38:46 AM
    Author     : Emily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Zona</title>
        <link rel="stylesheet" href="../recursos/css/tabla.css"/>
    </head>
    <body>
        <form method="POST" action="../AgregarZona.do" name="frmZona">
            <div class="CSSTableGenerator">
                <table>
                    <tr>
                        <th colspan="2">CATALOGO ZONAS</th>
                    </tr>
                    <tr>
                        <td><label for="idZona">Id Zona</label></td>
                        <td><input type="text" name="idZona" id="idZona"></td>
                    </tr>
                    <tr>
                        <td><label for="nombreZona">Nombre Zona</label></td>
                        <td><input type="text" name="nombreZona" id="nombreZona"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Guardar"></td>
                        <td><a href="../MostrarZonas.do">Regresar</a></td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>