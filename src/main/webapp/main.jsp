<%-- 
    Document   : main
    Created on : May 9, 2020, 4:28:50 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--Específica da Página-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <!--CABEÇALHO-->
        <div class="container-fluid">
            <div class="row cabecalho">
                <div class="col-lg-2 col-sm-2"><!--BUTTON HUMBURGER-->
                    <button id="hamburger" type="button" class="btn btn-outline-dark"><span class="fas fa-bars"></span></button>
                </div>
                <div class="col-lg-3 col-sm-3"><!--LOGO CABEÇALHO-->
                    <!--Colorir logo efeito em jquery - usa-se o id #logocab-->
                    <a  href="start.jsp">
                        <img id="logocab" src="img/grupo-2.png" alt="Logo Muchachos Perfumaria">
                    </a>
                </div>
                <div class="col-lg-3 col-sm-3"><!--HORA E DATA-->
                    <h1 id="calendario"></h><!--Data e calendario feito em jquery - usa-se o id #calendario-->
                </div>
                <div class="col-lg-3 col-sm-3"><!--USUÁRIO-->
                    <h1><span class="fas fa-user mr-1"></span>${sessionScope.funcionarioSessao.nome}</h>
                </div>
                <div class="col-lg-1 col-sm-1"><!--SAIR DO SISTEMA-->
                    <a class="btn btn-outline-dark" href="LogoutServlet" role="button">Sair <span class="fas fa-sign-out-alt"></span></a>
                </div>
            </div>
        </div>
        <!--BARRA NAVEGACAO LATERAL-->
        <div id="barra-lateral" class="barra-lateral"><!--expandir/recolher, feito em jquery - usa o id #barra-lateral-->
            <ul><!--Colorir botões ao apertar, feito em jquery - usa a classe .item-linha-->
                <c:if test="${'Gerente' != funcionarioSessao.cargo && 'Diretor' != funcionarioSessao.cargo}">
                    <c:if test="${'Venda' == funcionarioSessao.departamento || 'admin@muchachos' == funcionarioSessao.email}">
                        <p>Vendas</p>
                        <li><a class="item-linha" href="venda.jsp"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
                        <li><a class="item-linha" href="cadastroCliente.jsp"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
                        <li><a class="item-linha" href="ConsultarClienteServlet"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
                        <li><a class="item-linha" href="consultaProdutoServlet"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
                    </c:if>
                    <c:if test="${'Marketing' == funcionarioSessao.departamento || 'admin@muchachos' == funcionarioSessao.email}">
                        <p>Marketing</p>
                        <li><a class="item-linha" href="cadastroProduto.jsp"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
                        <li><a class="item-linha" href="consultaProdutoServlet"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
                        <li><a class="item-linha" href="ConsultarClienteServlet"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
                    </c:if>
                    <c:if test="${'TI' == funcionarioSessao.departamento || 'admin@muchachos' == funcionarioSessao.email}">
                        <p>Tecnologia da Informação</p>
                        <li><a class="item-linha" href="cadastroFuncionario.jsp"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
                        <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                    </c:if>
                    <c:if test="${'Recursos Humanos' == funcionarioSessao.departamento || 'admin@muchachos' == funcionarioSessao.email}">
                        <p>Recursos Humanos</p>
                        <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                    </c:if>
                </c:if>
                <c:if test="${'Gerente' == funcionarioSessao.cargo || 'admin@muchachos' == funcionarioSessao.email}">
                    <p>Gerência</p>
                    <li><a class="item-linha" href="RelatoriosServlet"><span class="fas fa-chart-line mr-3"></span> Relatório Filial</a></li>
                </c:if>
                <c:if test="${'Diretor' == funcionarioSessao.cargo || 'admin@muchachos' == funcionarioSessao.email}">
                    <p>Diretoria</p>
                    <li><a class="item-linha" href="RelatoriosServlet"><span class="fas fa-chart-bar mr-3"></span> Relatório Geral</a></li>
                </c:if>
            </ul>
            <div class="copyright">
              <p>Copyright &copy; 2020 - By Muchachos Perfumaria</p>
            </div>
        </div>
        <!--SCRIPTS-->
        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!--6-Específica da página-->
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
