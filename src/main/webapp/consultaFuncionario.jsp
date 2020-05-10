<%-- 
    Document   : cadastroProduto
    Created on : 05/05/2020, 22:42:36
    Author     : valter lafuente junior
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <!-- Meta tags Obrigat�rias -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name=viewport content="width=device-width, initial-scale=1">
  <!--CSS -->
  <!--Fonts Awesome-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
  <!--Bootstrap-->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <!--Espec�fica da P�gina-->
  <link href="css/start.css" rel="stylesheet">
 
  <link href="css/componentes.css" rel="stylesheet">
  
  
  <link href="css/consultaProduto.css" rel="stylesheet">
  <!--Titulo e icone-->
  <link rel="shortcut icon" href="img/logo-branco.png"/>
  <title>Perfumaria Muchachos: In�cio do sistema</title>
</head>
<body>
  <!--CABE�ALHO-->
  <div class="container-fluid">
    <div class="row cabecalho">
      <div class="col-lg-2 col-sm-2"><!--BUTTON HUMBURGER-->
        <button id="hamburger" type="button" class="btn btn-outline-dark"><span class="fas fa-bars"></span></button>
      </div>
      <div class="col-lg-3 col-sm-3"><!--LOGO CABE�ALHO-->
        <!--Colorir logo efeito em jquery - usa-se o id #logocab-->
        <img id="logocab" src="img/grupo-2.png" alt="Logo Muchachos Perfumaria">
      </div>
      <div class="col-lg-3 col-sm-3"><!--HORA E DATA-->
        <h1 id="calendario"></h><!--Data e calendario feito em jquery - usa-se o id #calendario-->
        </div>
        <div class="col-lg-2 col-sm-2"><!--USU�RIO-->
          <h1><span class="fas fa-user"></span> Ramses Souza</h>
          </div>
          <div class="col-lg-1 col-sm-1"><!--SAIR DO SISTEMA-->
            <button type="button" class="btn btn-outline-dark" >Sair <span class="fas fa-sign-out-alt"></span></button>
          </div>
        </div>
      </div>
      <!--BARRA NAVEGACAO LATERAL-->
      <div id="barra-lateral" class="barra-lateral"><!--expandir/recolher, feito em jquery - usa o id #barra-lateral-->
        <ul><!--Colorir bot�es ao apertar, feito em jquery - usa a classe .item-linha-->
          <p>Vendas</p>
          <li><a class="item-linha" href="#"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
          <li><a class="item-linha" href="#"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
          <li><a class="item-linha" href="#"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
          <p>Marketing</p>
          <li><a class="item-linha" href="#"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
          <li><a class="item-linha" href="#"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
          <li><a class="item-linha" href="#"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
          <p>Tecnologia da Informa��o</p>
          <li><a class="item-linha" href="#"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
          <li><a class="item-linha" href="#"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
          <p>Recursos Humanos</p>
          <li><a class="item-linha" href="#"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
          <p>Ger�ncia</p>
          <li><a class="item-linha" href="#"><span class="fas fa-chart-line mr-3"></span> Relat�rio Filial</a></li>
          <p>Diretoria</p>
          <li><a class="item-linha" href="#"><span class="fas fa-chart-bar mr-3"></span> Relat�rio Geral</a></li>
        </ul>
      </div>
      <!--CONTEUDO DA PAGINA-->
      <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
      <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
        <h1>Gerenciamento de Colcaboradores</h1>
        <!--Formul�rio-->
        <form clas="formulario" action="consultaFuncionarioServlet"  method="get">  
            <h1 class="titulo-formulario">${mensagem}</h1>
          <!--Linha 1-->
          <div class="row">
            <div class="col-sm-5">
              <!--Campo de Pesquisa de produto-->
              <div class="input-group mb-2 mr-sm-2">
                <div class="input-group-prepend ">
                  <div class="input-group-text">
                    <span class="fas fa-pump-soap mr-1"></span>
                  </div>
                </div>
                <input class="form-control" placeholder="Digite nome ou cpf" type="text"  required name="Busca" >
              </div><!--Fim do campo de Pesquisa de produto-->
            </div>
            <div class="col-sm-2">
                <button class="btn btn-dark btn-block" type="submit" value= "Busca" >Pesquisar
                <span class="ml-1 fas fa-search"></span>
              </button>
            </div>
          </div><!--Fim da linha 1--> 
        </form><!--Fim do formulario--> 

        <!--Tabela--> 
        <div class="tabela">
          <table class="table table-sm table-secondary table-hover table-striped">   
            <thead class="thead-dark">
              <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>CPF</th>
                <th>EMAIL</th>
                <th>CARGO</th>
                <th>FILIAL</th>
                <th>DEPARTAMENTO</th>
                <th>STATUS</th>
                <th>EDITAR</th>
                <th>REMOVER</th>
              </tr>
            </thead        
	     <c:forEach var="f" items="${listaFuncionario}">
               
	      <tr>
	       <td> value="${f.getId()}" </td>
	       <td>${f.nome}</td>
	       <td>${f.cpf}</td>
               <td>${f.email}</td>
               <td>${f.cargo}</td>
	       <td>${f.filial}</td>
               <td>${f.departamento}</td>
	       <td>${f.status}</td>
	       <td><a href=funcionarioServlet?acao=Editar&id=${f.id}>Editar</a></td>
	        <td><a href=funcionarioServlet?acao=Excluir&id=${f.id}>Excluir</a></td>
	      </tr>
              
	     </c:forEach>
         
          </table>
              
          </div><!--Fim da Tabela--> 

          <!--1-jQuery.js-->
          <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
          <!--2-Popper.js-->
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
          <!--3-Bootstrap.js-->
          <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
          <!--4-Espec�fica da p�gina-->
          <script type="text/javascript" src="js/start.js"></script>
        </body>
        </html>