/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Departamento;
import modelo.Zona;

/**
 *
 * @author Emily
 */
public class ServletControlDepto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
             RequestDispatcher despachador = null;
            if (request.getServletPath().equals("/MostrarDepartamentos.do")) {
                List<Departamento> listaDeDepartamentos = new ArrayList();
                ControlDepartamento controldepartamento = new ControlDepartamento();
                listaDeDepartamentos = controldepartamento.ObtenerlistaDeDepartamentos();
                request.setAttribute("listaDeDepartamentos", listaDeDepartamentos);
                despachador = request.getRequestDispatcher("Catalogos/Departamento/MostrarDepartamentos.jsp");
            } else if (request.getServletPath().equals("/FormularioDepartamento.do")) {
                List<Zona> listaDeZonas = new ArrayList();
                ControlZona controlzona = new ControlZona();
                listaDeZonas = controlzona.ObtenerlistaDeZonas();
                request.setAttribute("listaZonas", listaDeZonas);
                despachador = request.getRequestDispatcher("Catalogos/Departamento/FormularioDepartamento.jsp");
            } else if (request.getServletPath().equals("/AgregarDepartamento.do")) {
                Zona zona = new Zona();
                int id_zona = Integer.parseInt(request.getParameter("id_zona"));
                zona.setIdzona(id_zona);
                int id_depto = Integer.parseInt(request.getParameter("id_depto"));
                String nombre_depto = request.getParameter("nombre_depto");
                // Obtener los datos de zona
                ControlZona controlzona = new ControlZona(zona.getIdzona());
                zona = controlzona.obtenerZona();
                Departamento departamento = new Departamento(id_depto, zona, nombre_depto);
                ControlDepartamento controldepartamento = new ControlDepartamento(departamento);
                controldepartamento.guardarDepartamento();
                despachador = request.getRequestDispatcher("MostrarDepartamentos.do");
            } else if (request.getServletPath().equals("/ModificarDepartamento.do")) {
                Departamento departamento = new Departamento();
                departamento.setIddepartamento(Integer.parseInt(request.getParameter("id_depto")));
                ControlZona controlzona = new ControlZona();
                List<Zona> listaDeZonas = controlzona.ObtenerlistaDeZonas();
                request.setAttribute("listaZonas", listaDeZonas);
                // buscar por departamento
                ControlDepartamento controldepartamento = new ControlDepartamento(departamento.getIddepartamento());
                departamento = controldepartamento.obtenerDepartamento();
                request.setAttribute("objDepartamento", departamento);
                despachador = request.getRequestDispatcher("Catalogos/Departamento/ModificarDepartamento.jsp");
            } else if (request.getServletPath().equals("/BorrarDepartamento.do")) {
                Departamento departamento = new Departamento();
                departamento.setIddepartamento(Integer.parseInt(request.getParameter("id_depto")));
                ControlDepartamento controldepartamento = new ControlDepartamento(departamento.getIddepartamento());
                departamento = controldepartamento.obtenerDepartamento();
                controldepartamento.eliminarDepartamento(departamento);
                despachador = request.getRequestDispatcher("MostrarDepartamentos.do");
            } else if (request.getServletPath().equals("/EditarDepartamento.do")) {
                Zona zona = new Zona();
                int id_depto = Integer.parseInt(request.getParameter("id_depto"));
                int id_zona = Integer.parseInt(request.getParameter("id_zona"));
                zona.setIdzona(id_zona);
                String nombre_depto = request.getParameter("nombre_depto");
                ControlZona controlzona = new ControlZona(zona.getIdzona());
                zona = controlzona.obtenerZona();
                Departamento departamento = new Departamento(id_depto, zona, nombre_depto);
                ControlDepartamento controldepartamento = new ControlDepartamento(departamento);
                controldepartamento.actualizarDepartamento(departamento);
                despachador = request.getRequestDispatcher("MostrarDepartamentos.do");
            }
            despachador.forward(request, response);
        }
//    }
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
