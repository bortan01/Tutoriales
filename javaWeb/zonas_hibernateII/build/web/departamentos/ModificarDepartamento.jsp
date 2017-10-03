<%-- 
    Document   : ModificarDepartamento
    Created on : 08-23-2017, 11:17:23 AM
    Author     : Emily
--%>

<%@page import="sv.edu.ues.hibernate.Zona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sv.edu.ues.hibernate.Departamento"%>
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
        <%
            Departamento departamento = new Departamento();
            departamento = (Departamento) request.getAttribute("objDepartamento");
        %>
        
        <form method="GET" action="EditarDepartamento.do" name="frmModificar">
             <div class="CSSTableGenerator">
                <table>
                    <tr><td colspan="2">MODIFICAR DEPARTAMENTO</td></tr>
                    <tr>
                        <td><label for="id_depto">ID DEPARTAMENTO</label></td>
                        <td><input type="text" readonly="readonly" value="<%=departamento.getIdDepto()%>" name="id_depto" id="id_depto"></td>
                    </tr>
                    <tr>
                        <td><label for="id_zona">ZONA</label></td>
                        <td>
                            <select name="id_zona" id="id_zona">
                                    <option value="SELECCIONAR">--Seleccionar--</option>
                                    
                                <%

                                    ArrayList<Zona> lstZonas = (ArrayList<Zona>) request.getAttribute("listaZonas");

                                    for(Zona zona: lstZonas)
                                    {
                                        if(zona.getIdZona() == departamento.getZona().getIdZona() )
                                        {
                                        %>
                                            <option value="<%=zona.getIdZona()%>" selected="selected" >
                                                <%= zona.getNombreZona()%>
                                            </option>
                                        <%
                                        } 
                                        else 
                                        {
                                        %>
                                            <option value="<%=zona.getIdZona()%>">
                                                <%=zona.getNombreZona() %>
                                            </option>
                                        <%
                                        }                                   
                                    }  
                                %>
                                </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nombre_depto">NOMBRE DEPARTAMENTO</label></td>
                        <td><input name="nombre_depto" value="<%=departamento.getNombreDepto()%>"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Modificar" name="modificar" onclick="validar()"></td>
                        <td></td>
                    </tr>
                </table>
             </div>
        </form>
    </body>
</html>
