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
 * @alter Ramses Souza 19/06/2020
 */
@WebServlet(name = "DetalhesServlet", urlPatterns = {"/DetalhesServlet"})
public class DetalhesServlet extends HttpServlet {

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
        }catch (SQLException e){
           response.getWriter().write("Erro de banco de dados: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            response.getWriter().write("Erro de Driver: " + e.getMessage());
        }
        response.setContentType(
                "application/json");
        response.setCharacterEncoding(
                "UTF-8");
        response.getWriter()
                .write(json);
    }
}
