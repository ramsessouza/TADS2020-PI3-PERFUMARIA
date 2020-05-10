package com.muchachos.servelet;

import com.muchachos.dao.ProdutoDao;
import com.muchachos.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Souza de Queiroz
 */
public class CadastroProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String quantidade = request.getParameter("quantidade");
        String preco = request.getParameter("preco");
        String status = request.getParameter("status");
        String descricao = request.getParameter("descricao");

        Produto produto = new Produto(nome, preco, quantidade, descricao, categoria, status);
        boolean ok = ProdutoDao.cadastrarProduto(produto);
        PrintWriter out = response.getWriter();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
