/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.servelet;

import com.muchachos.dao.FuncionarioDao;
import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valter Lafuente Junior
 */
@WebServlet(name = "buscarFuncionarioServlet", urlPatterns = {"/buscarFuncionarioServlet"})
public class BuscarFuncionarioServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
	try {
	  List<Funcionario> listaFuncionario = FuncionarioDao.buscar(request.getParameter("Busca"));			
          request.setAttribute("listaFuncionario", listaFuncionario);	
			
	} catch (Exception e) {
	  request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			
	   }
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/buscaFuncionario.jsp");
    	  dispatcher.forward(request, response);
	}  
    }

