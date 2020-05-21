package com.muchachos.servelet;

import com.google.gson.Gson;
import com.muchachos.dao.RelatorioDao;
import com.muchachos.model.Detalhes;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.client.Entity.json;

/**
 *
 * @author Fabio Vieira
 */
@WebServlet(name = "DetalhesServlet", urlPatterns = {"/DetalhesServlet"})
public class DetalhesServlet extends HttpServlet {

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
        RelatorioDao detalhes = new RelatorioDao();
        String i = request.getParameter("id");

        String categoria = request.getParameter("categoria");
        int id = 0;
        if (i == null) {
            id = 0;
        } else {
            id = id = Integer.parseInt(i);
        }

        if (categoria.equals(
                "todas")) {
            categoria = "%";
        }

        String json = null;

        try {
            List<Detalhes> products = detalhes.getDetalhes(id, categoria);
            json = new Gson().toJson(products);

        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
        }

        response.setContentType(
                "application/json");
        response.setCharacterEncoding(
                "UTF-8");
        response.getWriter()
                .write(json);
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
        //processRequest(request, response);
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
