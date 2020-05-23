<%-- 
    Document   : consultaCliente
    Created on : 05/05/2020, 18:32:39
    Author     : Otávio Barros
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--CSS -->
        <!--Fonts Awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <!--Bootstrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!--Específica da Página-->
        <link href="css/start.css" rel="stylesheet">
        <link href="css/consultas.css" rel="stylesheet">
        <link href="css/componentes.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Consulta de clientes</title>
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
            <ul><!--Colorir botões ao apertar, feito em jabascript - usa a classe .item-linha-->
                <p>Vendas</p>
                <li><a class="item-linha" href="venda.jsp"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
                <li><a class="item-linha" href="cadastroCliente.jsp"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
                <li><a class="item-linha" href="consultaCliente.jsp"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
                <p>Marketing</p>
                <li><a class="item-linha" href="cadastroProduto.jsp"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
                <li><a class="item-linha" href="consultaProduto.jsp"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
                <li><a class="item-linha" href="consultaCliente.jsp"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
                <p>Tecnologia da Informação</p>
                <li><a class="item-linha" href="cadastroFuncionario.jsp"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
                <li><a class="item-linha" href="consultaFuncionario.jsp"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Recursos Humanos</p>
                <li><a class="item-linha" href="consultaFuncionario.jsp"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Gerência</p>
                <li><a class="item-linha" href="relatorios.jsp"><span class="fas fa-chart-line mr-3"></span> Relatório Filial</a></li>
                <p>Diretoria</p>
                <li><a class="item-linha" href="relatorios.jsp"><span class="fas fa-chart-bar mr-3"></span> Relatório Geral</a></li>
            </ul>
        </div>
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <h1>Consulta de Clientes</h1>
            <!--Formulário-->
            <form class="formulario" action="ConsultarClienteServlet" method="POST"> 
                <!--Linha 1-->
                <div class="row">
                    <!--Coluna 1-->
                    <div class="col-sm-5">
                        <!--Campo de Pesquisa de cliente-->
                        <div class="input-group mb-2 mr-sm-2">
                            <div class="input-group-prepend ">
                                <div class="input-group-text">
                                    <span class="fas fa-users mr-1"></span>
                                </div>
                            </div>
                            <input name="pesquisaCliente" class="form-control" maxlength="40" placeholder="Pesquisar Cliente por Nome ou CPF" type="text">
                        </div><!--Fim do campo de Pesquisa de cliente-->
                    </div><!--Fim da Coluna 1-->
                    <!--Coluna 2-->
                    <div class="col-sm-2">
                        <!--Botão de Pesquisa de cliente-->
                        <button class="btn btn-dark btn-block" type="submit">Pesquisar
                            <span class="ml-1 fas fa-search"></span>
                        </button>
                    </div><!--Fim Coluna 2-->
                </div><!--Fim da linha 1--> 
            </form><!--Fim do formulario--> 
            <!--Tabela--> 
            <div class="tabela">
                <table class="table table-sm table-secondary table-hover table-striped">     
                    <thead class="thead-dark">
                        <tr>
                            <th class="td-id">#</th>
                            <th class="td-nome">NOME</th>
                            <th class="td-email">E-MAIL</th>
                            <th class="td-telefone">TELEFONE</th>
                            <th class="td-nascimento">NASCIMENTO</th>
                            <th class="td-sexo">SEXO</th>
                            <th>ESTADO</th>
                            <th class="td-logradouro">LOGRADOURO</th>
                            <th>NÚMERO</th>
                            <th class="td-editar">EDITAR</th>
                            <th class="td-remover">REMOVER</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listaClientes" items="${clientes}">
                            <tr>
                                <td class="td-id">${listaClientes.id}</td>
                                <td class="td-nome">${listaClientes.nome}</td>
                                <td class="td-email">${listaClientes.email}</td>
                                <td class="td-telefone">${listaClientes.telefone}</td>
                                <td class="td-nascimento">${listaClientes.dataNascimento}</td>
                                <td class="td-sexo">${listaClientes.sexo}</td>
                                <td>${listaClientes.estado}</td>
                                <td class="td-logradouro">${listaClientes.logradouro}</td>
                                <td>${listaClientes.numero}</td>
                                <td class="td-remover"><a href="EditarClienteServlet?&id=${listaClientes.id}"><span class="fas fa-edit"></span></a></td>
                                <td class="td-editar"><a href="ExcluirClienteServlet?&id=${listaClientes.id}"><span class="fas fa-times"></span></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div><!--Fim da Tabela--> 
        </div>
        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!--4-Específica da página-->
        <script type="text/javascript" src="js/start.js"></script>
    </body>
</html>