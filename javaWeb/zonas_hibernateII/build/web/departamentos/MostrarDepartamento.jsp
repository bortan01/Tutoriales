<%-- 
    Document   : MostrarDepartamento
    Created on : 08-23-2017, 11:17:42 AM
    Author     : Emily
--%>

<%@page import="sv.edu.ues.hibernate.Departamento"%>
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
                    <th>ZONA</th>
                    <th>DEPARTAMENTO</th>
                    <th colspan="2">ACCIONES</th>
                </tr>
                <% 
                    
                        List<Departamento> lstDepartamentos = (List<Departamento>) request.getAttribute("listaDeDepartamentos");
                        
                        for(Departamento departamento:lstDepartamentos ){
                    %>
                    <tr>
                        <td><%=departamento.getZona().getNombreZona() %></td>
                        <td><%=departamento.getNombreDepto() %></td>
                      
                       <td><a href="BorrarDepartamento.do?id_depto=<%=departamento.getIdDepto()%>">Borrar</a></td>
                        <td><a href="ModificarDepartamento.do?id_depto=<%=departamento.getIdDepto()%>">Modificar</a></td>
                    </tr>
                    <% }
                       
                    %>
                    <tr>
                        <td colspan="4"><a href="FormularioDepartamento.do">Agregar nuevo</a></td>
                    </tr>
            </table>
        </div>
    </body>
</html>
