<%-- 
    Document   : main
    Created on : May 9, 2020, 4:28:50 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
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
                    <img id="logocab" src="img/grupo-2.png" alt="Logo Muchachos Perfumaria">
                </div>
                <div class="col-lg-3 col-sm-3"><!--HORA E DATA-->
                    <h1 id="calendario"></h><!--Data e calendario feito em jquery - usa-se o id #calendario-->
                </div>
                <div class="col-lg-2 col-sm-2"><!--USUÁRIO-->
                    <h1><span class="fas fa-user"></span> Ramses Souza</h>
                </div>
                <div class="col-lg-1 col-sm-1"><!--SAIR DO SISTEMA-->
                    <button type="button" class="btn btn-outline-dark" >Sair <span class="fas fa-sign-out-alt"></span></button>
                </div>
            </div>
        </div>
        <!--BARRA NAVEGACAO LATERAL-->
        <div id="barra-lateral" class="barra-lateral"><!--expandir/recolher, feito em jquery - usa o id #barra-lateral-->
            <ul><!--Colorir botões ao apertar, feito em jquery - usa a classe .item-linha-->
                <p>Vendas</p>
                <li><a class="item-linha" href="venda.jsp"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
                <li><a class="item-linha" href="cadastroCliente.jsp"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
                <li><a class="item-linha" href="consultaCliente.jsp"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
                <p>Marketing</p>
                <li><a class="item-linha" href="cadastroProduto.jsp"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
                <li><a class="item-linha" href="consultaProdutoServlet"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
                <li><a class="item-linha" href="consultaCliente.jsp"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
                <p>Tecnologia da Informação</p>
                <li><a class="item-linha" href="cadastroFuncionario.jsp"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
                <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Recursos Humanos</p>
                <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Gerência</p>
                <li><a class="item-linha" href="relatorios.jsp"><span class="fas fa-chart-line mr-3"></span> Relatório Filial</a></li>
                <p>Diretoria</p>
                <li><a class="item-linha" href="relatorios.jsp"><span class="fas fa-chart-bar mr-3"></span> Relatório Geral</a></li>
            </ul>
        </div>
    </body>
</html>
