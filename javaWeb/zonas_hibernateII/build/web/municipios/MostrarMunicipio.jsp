<%-- 
    Document   : MostrarMunicipio
    Created on : 08-23-2017, 11:18:27 AM
    Author     : Emily
--%>

<%@page import="sv.edu.ues.hibernate.Municipio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/tabla.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="CSSTableGenerator">
            <table border="2">
                <tr>
                    <th>DEPARTAMENTO</th>
                    <th>MUNICIPIO</th>
                    <th colspan="2">ACCIONES</th>
                </tr>
                <% 
                    
                        List<Municipio> lstMunicipios = (List<Municipio>) request.getAttribute("listaDeMunicipios");
                        
                        for(Municipio municipio:lstMunicipios ){
                    %>
                    <tr>
                        <td><%=municipio.getDepartamento().getNombreDepto() %></td>
                        <td><%=municipio.getNombreMuni()%></td>
                        <td><a href="BorrarMunicipio.do?id_muni=<%=municipio.getIdMuni()%>">Borrar</a></td>
                        <td><a href="ModificarMunicipio.do?id_muni=<%=municipio.getIdMuni()%>">Modificar</a></td>
                    </tr>
                    <% }
                       
                    %>
                    <tr>
                        <td colspan="4"><a href="FormularioMunicipio.do">Agregar nuevo</a></td>
                    </tr>
            </table>
        </div>
    </body>
</html>
