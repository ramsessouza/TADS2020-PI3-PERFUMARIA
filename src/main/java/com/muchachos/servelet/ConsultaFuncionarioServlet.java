package com.muchachos.servelet;

import com.muchachos.dao.FuncionarioDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valter Lafuente junior
 */
@WebServlet(name = "consultaFuncionarioServlet", urlPatterns = {"/consultaFuncionarioServlet"})
public class ConsultaFuncionarioServlet extends HttpServlet {

        private FuncionarioDao funcionarioDao = new FuncionarioDao(); 
	private static final long serialVersionUID = 1L;
       
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String acao = request.getParameter("acao"); 
 String id = request.getParameter("id");
  try {
	if(acao != null && acao.equals("Excluir")) {  
	Integer cod = Integer.parseInt(id);
	funcionarioDao.excluir(cod);
	request.setAttribute("mensagem", "Funcionario Excluido com sucesso!!");
			}
	request.setAttribute("funcionarios", funcionarioDao.getFuncionario1());
			
	} catch (SQLException e) {
	request.setAttribute("mensagem","Erro de banco de dados");
			
	} catch (ClassNotFoundException e) {
			
	request.setAttribute("mensagem", "Erro de driver");
		}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/consultaFuncionario.jsp");
	    dispatcher.forward(request, response);
	}
}
	