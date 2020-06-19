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
 * @author Fabio Vieira
 * @alter Ramses Souza
 * 19/06/2020 15:11
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/RelatoriosServlet"})
public class RelatoriosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RelatorioDao relDao = new RelatorioDao();
        String cliente = request.getParameter("cliente");

        String diaIni = request.getParameter("dataDe");
        String diaFim = request.getParameter("dataPara");

        String filial = request.getParameter("filial");
        String categoria = request.getParameter("categ");

        Timestamp de = null;
        Timestamp para = null;

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (cliente == null) {
            cliente = "";
        }

        cliente = "%" + cliente + "%";

        try {
            if (diaIni == null || diaIni.equals("")) {
                Date c = sdf.parse("2020-01-01 00:00:00");
                long l = c.getTime();
                de = new Timestamp(l);
            } else {
                diaIni += " 00:00:01";
                Date c = sdf.parse(diaIni);
                long l = c.getTime();
                de = new Timestamp(l);
            }

            if (diaFim == null || diaFim.equals("")) {
                para = new Timestamp(System.currentTimeMillis());
            } else {
                diaFim += " 23:59:59";
                Date c = sdf.parse(diaFim);
                long l = c.getTime();
                para = new Timestamp(l);
            }
        } catch (Exception e) {
            request.setAttribute("mensagemErro","Erro de código: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorios.jsp");
            dispatcher.forward(request, response);
        }catch (SQLException e){
            request.setAttribute("mensagemErro","Erro de banco de dados: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);

        }catch (ClassNotFoundException e) {
            request.setAttribute("mensagemErro","Erro de Driver: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RelatorioDao relDao = new RelatorioDao();
        String cliente = request.getParameter("cliente");

        String diaIni = request.getParameter("dataDe");
        String diaFim = request.getParameter("dataPara");

        String filial = request.getParameter("filial");
        String categoria = request.getParameter("categ");

        Timestamp de = null;
        Timestamp para = null;

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (cliente == null) {
            cliente = "";
        }

        cliente = "%" + cliente + "%";

        try {
            if (diaIni == null || diaIni.equals("")) {
                Date c = sdf.parse("2020-01-01 00:00:00");
                long l = c.getTime();
                de = new Timestamp(l);
            } else {
                diaIni += " 00:00:01";
                Date c = sdf.parse(diaIni);
                long l = c.getTime();
                de = new Timestamp(l);
            }

            if (diaFim == null || diaFim.equals("")) {
                para = new Timestamp(System.currentTimeMillis());
            } else {
                diaFim += " 23:59:59";
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/relatorios.jsp");
            dispatcher.forward(request, response);
        }catch (SQLException e){
            request.setAttribute("mensagemErro","Erro de banco de dados: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);

        }catch (ClassNotFoundException e) {
            request.setAttribute("mensagemErro","Erro de Driver: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);
        }
    }
}
