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
import modelo.Zona;

/**
 *
 * @author Emily
 */
public class ServletControlZona extends HttpServlet {

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
            String pagina = request.getServletPath();
            if (pagina.equals("/MostrarZonas.do")) {
                List<Zona> listaDeZonas = new ArrayList();
                ControlZona controlzona = new ControlZona();
                listaDeZonas = controlzona.ObtenerlistaDeZonas();
                request.setAttribute("listaDeZonas", listaDeZonas);
                despachador = request.getRequestDispatcher("zonas/MostrarZonas.jsp");
            } else if (pagina.equals("/AgregarZona.do")) {
                String idZona = request.getParameter("idZona");
                int id_zona = Integer.parseInt(idZona);
                String nombreZona = request.getParameter("nombreZona");
                Zona zona = new Zona(id_zona, nombreZona);
                ControlZona controlzona = new ControlZona(zona);
                controlzona.guardarZona();               
                despachador = request.getRequestDispatcher("MostrarZonas.do");
            } else if (pagina.equals("/BorrarZona.do")) {
                int idZona = Integer.parseInt(request.getParameter("idZona"));
                Zona zona = new Zona(idZona);
                ControlZona controlzona = new ControlZona(idZona);
                controlzona.eliminarZona(zona);
                despachador = request.getRequestDispatcher("MostrarZonas.do");
            } else if (pagina.equals("/ModificarZona.do")) {
                Zona zona = new Zona();
                zona.setIdzona(Integer.parseInt(request.getParameter("idZona")));
                ControlZona controlzona = new ControlZona(zona.getIdzona());
                        zona = controlzona.obtenerZona();
                request.setAttribute("zona", zona);
                despachador = request.getRequestDispatcher("zonas/ModificarZona.jsp");
            } else if (pagina.equals("/UpdateZona.do")) {
                int idZona = Integer.parseInt(request.getParameter("idZona"));
                String nombreZona = request.getParameter("nombreZona");
                Zona zona = new Zona(idZona, nombreZona);
                ControlZona controlzona = new ControlZona();
                controlzona.actualizarZona(zona);
                despachador = request.getRequestDispatcher("MostrarZonas.do");
            }

            despachador.forward(request, response);
        }
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
