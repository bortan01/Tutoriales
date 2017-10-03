<%-- 
    Document   : AgregarMunicipio
    Created on : 08-23-2017, 11:18:00 AM
    Author     : Emily
--%>

<%@page import="sv.edu.ues.hibernate.Departamento"%>
<%@page import="sv.edu.ues.hibernate.Zona"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

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
        <form method="GET" action="AgregarMunicipio.do" name="frmMunicipio">
            <div class="CSSTableGenerator">
                <table>
                    <tr><td colspan="2">FORMULARIO MUNICIPIOS</td></tr>
                    <tr>
                        <td><label for="id_depto">DEPARTAMENTO</label></td>
                        <td>
                            <select name="id_depto" id="id_depto">
                                <option value="SELECCIONAR">--Seleccionar--</option>
                            <%

                                ArrayList<Departamento> lstDepartamentos = (ArrayList<Departamento>) request.getAttribute("listaDepartamentos");

                                for(Departamento departamento: lstDepartamentos)
                                {
                            %>
                            <option value="<%=departamento.getIdDepto()%>" >
                                <%=departamento.getNombreDepto()%>
                            </option>
                            <%
                                }
                                
                            %>
                            </select></td>
                    </tr>
                    
                     <tr>
                        <td><label for="id_muni">ID MUNICIPIO</label></td>
                        <td><input type="text" name="id_muni" id="id_muni" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="nombre_muni">NOMBRE MUNICIPIO</label></td>
                        <td><input type="text" name="nombre_muni" id="nombre_muni" /></td>
                    </tr>
                    
                    <tr>
                        <td>
                            <input type="submit" value="Agregar" onclick="validarMuni()"/>
                        </td>
                        <td>JSP 2016</td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
