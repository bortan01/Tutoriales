<%-- 
    Document   : MostrarZonas
    Created on : 08-23-2017, 11:15:29 AM
    Author     : Emily
--%>


<%@page import="java.util.List"%>
<%@page import="modelo.Zona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Zonas</title>
        <link rel="stylesheet" href="recursos/css/tabla.css"/>
    </head>
    <body>
        <div class="CSSTableGenerator">
            <table border="2">
                <tr>
                    <th>ID ZONA</th>
                    <th>NOMBRE</th>
                    <th colspan="2">ACCIONES</th>
                </tr>
                <%
                    List<Zona> lstZonas =(List<Zona>) request.getAttribute("listaDeZonas");
                    for(Zona actual : lstZonas)                        
                    {
                %>
                <tr>
                    <td><%=actual.getIdzona()%></td>
                    <td><%=actual.getNombrezona()%></td>
                    <td><a href="ModificarZona.do?idZona=<%=actual.getIdzona()%>">Modificar</a></td>
                    <td><a href="BorrarZona.do?idZona=<%=actual.getIdzona()%>">Borrar</a></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="4">
                        <a href="zonas/AdicionarZona.jsp">AGREGAR ZONA</a>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
