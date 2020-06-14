package com.muchachos.servelet;

import com.muchachos.dao.ProdutoDao;
import com.muchachos.model.Produto;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 12/06/2020
 *
 * @author Diego Souza de Queiroz
 */
@WebServlet(name = "CadastroProdutoServlet", urlPatterns = {"/CadastroProdutoServlet"})
public class CadastroProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //não estamos usando doGet
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = new Produto();
        produto.setNome(request.getParameter("nome"));
        produto.setStatus(request.getParameter("status"));
        produto.setCategoria(request.getParameter("categoria"));
        produto.setPreco(Float.parseFloat(request.getParameter("preco")));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        produto.setDescricao(request.getParameter("descricao"));

        try {
            produtoDao.salvar(produto);
            response.getWriter().write(produto.getNome());

        } catch (SQLException e) {
            response.getWriter().write("Erro de banco de dados: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            response.getWriter().write("Erro de Driver: " + e.getMessage());
        } catch (Exception e) {
            response.getWriter().write("Erro de Código: " + e.getMessage());
        }
    }
}
