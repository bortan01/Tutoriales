<%-- 
    Document   : ModificarZona
    Created on : 08-23-2017, 11:15:13 AM
    Author     : Emily
--%>


<%@page import="modelo.Zona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="recursos/css/tabla.css"/>
        <title>Modificar Zona</title>
    </head>
    <body>
        <%
            Zona zona = (Zona)request.getAttribute("zona");
        %>
        <form method="GET" action="UpdateZona.do" name="frmZona">
            <div class="CSSTableGenerator" >
            <table>
                <tr>
                    <td colspan="2">Modificar Zona seleccionada</td>
                </tr>
                <tr>
                    <td><label for="idZona">ID ZONA</label>  </td>
                    <td><input type="text" readonly value="<%=zona.getIdzona()%>" name="idZona" id="idZona"></td>
                </tr>
                <tr>
                    <td><label for="nombreZona">NOMBRE ZONA</label>  </td>
                    <td><input type="text" value="<%=zona.getNombrezona()%>" name="nombreZona" id="nombreZona"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Modificar" /></td>
                </tr>
            </table>
            </div>
        </form>
    </body>
</html>

