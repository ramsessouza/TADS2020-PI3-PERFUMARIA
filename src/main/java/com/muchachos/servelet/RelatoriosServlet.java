package com.muchachos.servelet;

import com.google.gson.Gson;
import com.muchachos.dao.RelatorioDao;
import com.muchachos.model.Detalhes;
import com.muchachos.model.Relatorio;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio Vieira
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/RelatoriosServlet"})
public class RelatoriosServlet extends HttpServlet {

    private RelatorioDao relDao = new RelatorioDao();

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cliente = request.getParameter("cliente");

        String diaIni = request.getParameter("dataDe");
        String diaFim = request.getParameter("dataPara");

        String filial = request.getParameter("filial");
        String categoria = request.getParameter("categ");

        Timestamp de = null;
        Timestamp para = null;

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (cliente == null) {
            cliente = "";
        }

        cliente = "%" + cliente + "%";

        try {
            if (diaIni == null || diaIni.equals("")) {
                Date c = sdf.parse("2020-01-01");
                long l = c.getTime();
                de = new Timestamp(l);
            } else {
                Date c = sdf.parse(diaIni);
                long l = c.getTime();
                de = new Timestamp(l);
            }

            if (diaFim == null || diaFim.equals("")) {
                para = new Timestamp(System.currentTimeMillis());
            } else {
                Date c = sdf.parse(diaFim);
                long l = c.getTime();
                para = new Timestamp(l);
            }
        } catch (Exception e) {
            System.out.println("" + e.toString());
        }
        if (filial == null || filial.equals("todas")) {
            filial = "%";
        }

        if (categoria == null || categoria.equals("todas")) {
            categoria = "%";
        }

        try {
            List<Relatorio> r = relDao.getVendas(de, para, filial, cliente, categoria);
            request.setAttribute("vendas", r);

        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorios.jsp");
        dispatcher.forward(request, response);

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
