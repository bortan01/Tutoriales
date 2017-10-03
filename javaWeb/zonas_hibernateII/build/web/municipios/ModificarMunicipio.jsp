<%-- 
    Document   : ModificarMunicipio
    Created on : 08-23-2017, 11:18:13 AM
    Author     : Emily
--%>

<%@page import="sv.edu.ues.hibernate.Departamento"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sv.edu.ues.hibernate.Municipio"%>
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
        <%
            Municipio municipio = new Municipio();
            municipio = (Municipio) request.getAttribute("objMunicipio");
        %>
        
        <form method="GET" action="EditarMunicipio.do" name="frmModificar">
             <div class="CSSTableGenerator">
                <table>
                    <tr><td colspan="2">MODIFICAR MUNICIPIO</td></tr>
                    <tr>
                        <td><label for="id_muni">ID MUNICIPIO</label></td>
                        <td><input type="text" readonly="readonly" value="<%=municipio.getIdMuni()%>" name="id_muni" id="id_muni"></td>
                    </tr>
                    <tr>
                        <td><label for="id_depto">DEPARTAMENTO</label></td>
                        <td>
                            <select name="id_depto" id="id_departamento">
                                    <option value="SELECCIONAR">--Seleccionar--</option>
                                    
                                <%

                                    ArrayList<Departamento> lstDepartamentos = (ArrayList<Departamento>) request.getAttribute("listaDepartamentos");

                                    for(Departamento departamento: lstDepartamentos)
                                    {
                                        if(departamento.getIdDepto() == municipio.getDepartamento().getIdDepto())
                                        {
                                        %>
                                            <option value="<%=departamento.getIdDepto()%>" selected="selected" >
                                                <%= departamento.getNombreDepto() %>
                                            </option>
                                        <%
                                        } 
                                        else 
                                        {
                                        %>
                                            <option value="<%=departamento.getIdDepto()%>">
                                                <%=departamento.getNombreDepto() %>
                                            </option>
                                        <%
                                        }                                   
                                    }  
                                %>
                                </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nombre_muni">NOMBRE MUNICIPIO</label></td>
                        <td><input name="nombre_muni" value="<%=municipio.getNombreMuni()%>"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Modificar" name="modificar" onclick="validarMuni()"></td>
                        <td></td>
                    </tr>
                </table>
             </div>
        </form>
    </body>
</html>
