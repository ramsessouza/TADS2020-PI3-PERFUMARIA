/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.servelet;

import com.muchachos.db.FuncionarioDao;
import com.muchachos.model.Funcionario;
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
 * @author Valter Lafuente Junior
 */
@WebServlet(name = "funcionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
	private FuncionarioDao funcionarioDao = new FuncionarioDao(); 
	
	
        
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		try {
			if(acao != null && acao.equals("Editar")) {
				Integer cod = Integer.parseInt(id); 
			    Funcionario funcionario = funcionarioDao.getFuncionarioId(cod);
			    request.setAttribute("funcionario", funcionario);
			} 
			
			request.setAttribute("funcionarios", funcionarioDao.getFuncionario());	
			
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			
	   }catch (ClassNotFoundException e) {
			
			request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
	   }
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/editarFuncionario.jsp");
		dispatcher.forward(request, response);
	}

	
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String sexo = request.getParameter("sexo");
		String estadoCivil = request.getParameter("estadoCivil");
		String dataNascimento = request.getParameter("dataNascimento");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String situacao = request.getParameter("situacao");
		String senha = request.getParameter("senha");
		String cargo = request.getParameter("cargo");
		String filial = request.getParameter("filial");
		String departamento = request.getParameter("departamento");
		String id = request.getParameter("id");
		Funcionario funcionario = new Funcionario(null,nome, cpf, rg, sexo, estadoCivil, dataNascimento,
				estado, cidade, bairro, logradouro, numero, complemento, telefone, email,situacao, senha, cargo, filial, departamento);
		if(id != null && !id.equals("")) {
			funcionario.setId(Integer.parseInt(id));
		}
		try {
			if(funcionario.getId() != null) {
				 funcionarioDao.atualizar(funcionario);
				 request.setAttribute("mensagem","Funcionario atualizado com sucesso!!!");
			}else {
			 funcionarioDao.salvar(funcionario);
			 request.setAttribute("mensagem","Funcionario salvo com sucesso!!!");
		  }
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
	    }catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
	   }
		try {
		  request.setAttribute("funcionario", funcionarioDao.getFuncionario());
	   } catch (SQLException e) {
		   
			request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
			 
	    }catch (ClassNotFoundException e) {
	    	
			request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("//WEB-INF/paginas/funcionario.jsp");
		dispatcher.forward(request, response);
		
	   }
}