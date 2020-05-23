package com.muchachos.servelet;

import com.muchachos.dao.ItensVendaDao;
import com.muchachos.dao.VendaDao;
import com.muchachos.model.ItemVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 22/05/2020
 * @author Ramses
 */
@WebServlet(name = "CadastroItensVendaServlet", urlPatterns = {"/CadastroItensVendaServlet"})
public class CadastroItensVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //não esta usando
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemVenda iten = new ItemVenda();
        
        iten.setIdVenda(Integer.parseInt(request.getParameter("idVenda")));
        iten.setId(Integer.parseInt(request.getParameter("idProduto")));
        iten.setQtdItens(Integer.parseInt(request.getParameter("qtdItens")));
        iten.setValorTotal(Float.parseFloat(request.getParameter("valorTotal")));
        
        try{
            ItensVendaDao itenVendaDao = new ItensVendaDao();
            itenVendaDao.salvar(iten);
            response.getWriter().write("Venda registrada!");
        }catch (SQLException e){
           response.getWriter().write("Erro de banco de dados: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            response.getWriter().write("Erro de Driver: " + e.getMessage());
        }catch (Exception e){
            response.getWriter().write("Erro de Código: " + e.getMessage());
        }
    }
}
