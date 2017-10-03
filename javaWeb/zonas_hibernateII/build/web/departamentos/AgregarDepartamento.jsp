<%-- 
    Document   : AgregarDepartamento
    Created on : 08-23-2017, 11:17:08 AM
    Author     : Emily
--%>


<%@page import="sv.edu.ues.hibernate.Zona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/tabla.css"/>
        <script type="text/javascript" src="resources/js/validaciones.js" ></script>
        <title>JSP Page</title>
    </head>
    <body> 
        <form method="GET" action="AgregarDepartamento.do" name="frmDepartamento">
            <div class="CSSTableGenerator">
                <table>
                    <tr><td colspan="2">FORMULARIO DEPARTAMENTOS</td></tr>
                    
                    <tr>
                        <td><label for="id_zona">ZONA</label></td>
                        <td>
                            <select name="id_zona" id="id_zona">
                                <option value="SELECCIONAR">--Seleccionar--</option>
                            <%

                                ArrayList<Zona> lstZonas = (ArrayList<Zona>) request.getAttribute("listaZonas");

                                for(Zona zona: lstZonas)
                                {
                            %>
                            <option value="<%=zona.getIdZona()%>" >
                                <%=zona.getNombreZona()%>
                            </option>
                            <%
                                }
                                
                            %>
                            </select
                    </tr>
                    
                    <tr>
                        <td><label for="id_depto">ID DEPARTAMENTO</label></td>
                        <td><input type="text" name="id_depto" id="id_depto" /></td>
                    </tr>
                     <tr>
                        <td><label for="titulo">NOMBRE DEPARTAMENTO</label></td>
                        <td><input type="text" name="nombre_depto" id="nombre_depto" /></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Agregar" onclick="validar()"/>
                        </td>
                        <td>JSP 2016</td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
