package com.emergentes.controlador;

import com.emergentes.dao.AlmacenDAO;
import com.emergentes.dao.AlmacenDAOimpl;
import com.emergentes.modelo.Almacen;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            Almacen alm = new Almacen();
            AlmacenDAO dao = new AlmacenDAOimpl();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                case "add":
                    request.setAttribute("almacen", alm);
                    request.getRequestDispatcher("frmalmacen.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    alm = dao.getById(id);
                    
                    request.setAttribute("almacen", alm);
                    request.getRequestDispatcher("frmalmacen.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Almacen> lista = dao.getAll();
                    request.setAttribute("almacen", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AlmacenDAO dao = new AlmacenDAOimpl();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");
        
        Almacen alm = new Almacen();
        alm.setId(id);
        alm.setDescripcion(descripcion);
        alm.setCantidad(cantidad);
        alm.setPrecio(precio);
        alm.setCategoria(categoria);
        try {
            if (id == 0) {
                //Adicionar reg
                dao.insert(alm);
            } else {
                //Actualizar reg
                dao.update(alm);
            }
        } catch (Exception ex) {
            System.out.println("Error al guardar datos...");
        }
        
        response.sendRedirect("Inicio");
    }
    
}
