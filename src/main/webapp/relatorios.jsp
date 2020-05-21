<%-- 
    Document   : RelatorioVendas
    Created on : May 7, 2020, 7:09:47 PM
    Author     : Fabio Vieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--CSS -->
        <link href="css/muchachos-style.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Relatório de Vendas</title>
    </head>
    <body>
        <!--import do cabeçalho e barra lateral-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina" style="text-align: center; overflow: no-display">
            <h1 class="espacamento">Relatório de Vendas</h1>
            <div class="row">
                <div class="col-lg-12" style="margin: auto">
                    <form action="RelatoriosServlet" method="GET">
                        <h1 class="titulo-formulario">${mensagem}</h1>
                        <div class="row">
                            <div class="col-md-3 col-sm-3">
                                <div class="form-group">
                                    <label>Cliente</label>
                                    <input type="text" class="form-control" name="cliente" maxlength="15" placeholder="Nome">
                                </div>
                            </div>

                            <div class="col-md-2 col-sm-2">
                                <div class="form-group">
                                    <label>De</label>
                                    <input name="dataDe" id="dataDe" type="date" class="form-control" >
                                </div>
                            </div>
                            <div class="col-md-2 col-sm-2">
                                <div class="form-group">
                                    <label>Até</label>
                                    <input name="dataPara" id="dataPara" type="date" class="form-control" >
                                </div>  
                            </div>

                            <div class="dropdown col-md-2 col-sm-2">
                                <div class="form-group">
                                    <label>Filial</label>
                                    <select name="filial" id="filial" class="form-control">
                                        <option value="todas">Todas</option>
                                        <option value="acre">Acre</option>
                                        <option value="alagoas">Alagoas</option>
                                        <option value="amapa">Amapá</option>
                                        <option value="amazonas">Amazonas</option>
                                        <option value="bahia">Bahia</option>
                                        <option value="ceara">Ceará</option>
                                        <option value="distrito federal">Distrito Federal</option>
                                        <option value="espirito santo">Espírito Santo</option>
                                        <option value="goias">Goiás</option>
                                        <option value="maranhao">Maranhão</option>
                                        <option value="mato grosso">Mato Grosso</option>
                                        <option value="mato grosso do sul">Mato Grosso do Sul</option>
                                        <option value="minas gerais">Minas Gerais</option>
                                        <option value="para">Pará</option>
                                        <option value="paraiba">Paraíba</option>
                                        <option value="parana">Paraná</option>
                                        <option value="pernambuco">Pernambuco</option>
                                        <option value="piaui">Piauí</option>
                                        <option value="rio de janeiro">Rio de Janeiro</option>
                                        <option value="rio grande do norte">Rio Grande do Norte</option>
                                        <option value="rio grande do sul">Rio Grande do Sul</option>
                                        <option value="rondonia">Rondônia</option>
                                        <option value="roraima">Roraima</option>
                                        <option value="santa catarina">Santa Catarina</option>
                                        <option value="são paulo">São Paulo</option>
                                        <option value="sergipe">Sergipe</option>
                                        <option value="tocantins">Tocantins</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-3 col-sm-2" style="top: 28px">
                                <div class="form-group">
                                    <input class="btn btn-dark" type="submit" value="Pesquisar">
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="offset-sm-0 col-md-2">
                                <label id="textoPadrao">Total:  </label>
                                <label id="totalPesquisa" class="mascara-decimais" size="5px">0</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>
                    </form>
                </div><hr>
                <h2 class="espacamento">Vendas</h2>
                <div class="tabela">
                    <table id="tableVendas" class="table table-sm table-secondary table-hover table-striped">   
                        <thead class="thead-dark">
                            <tr>
                                <th>Nº Venda</th>
                                <th>Cliente</th>
                                <th>Data</th>
                                <th>Qtd. Produtos</th>
                                <th>Total</th>
                                <th>Vend. Resp.</th>
                                <th>Filial</th>
                            </tr>
                        </thead>        
                        <c:forEach var="v" items="${vendas}">

                            <tr class="linha">
                                <td name="id">${v.id}</td>
                                <td>${v.cliente}</td>
                                <td>${v.data}</td>
                                <td>${v.qtd_itens}</td>
                                <td class="itemPreco">${v.total}</td>
                                <td>${v.vend_resp}</td>
                                <td>${v.filial}</td>
                            </tr>

                        </c:forEach>

                    </table>

                </div>
                <hr>
                <h2 class="espacamento">Detalhes da venda</h2>

                <div class="col-md-1 col-sm-2" style="top: 25px;">
                    <div class="form-group">
                        <label>Categoria</label>
                    </div>
                </div>
                <div class="dropdown col-md-2 col-sm-2" style="top: 15px">
                    <div class="form-group">
                        <select name="categoria" id="categoria" class="form-control">
                            <option value="todas">Todas</option>
                            <option value="raiz">Beleza</option>
                            <option value="cosmeticos">Cosmeticos</option>
                            <option value="perfumes">Perfumes</option>
                            <option value="utensilios">Utensilios</option>
                        </select>
                    </div>
                </div>
                <table class="table table-sm table-secondary table-hover table-striped" id="detalheTabela">
                    <thead class="thead-dark">
                    <th>Id do Produto</th>
                    <th>Nome do Produto</th>
                    <th>Quantidade</th>
                    <th>Categoria</th>
                    <th>Valor Unitário</th>
                    <th>Valor por Item</th>
                    </thead>
                    <tbody
                        
                </tbody>
            </table>
            <hr>
            <h1>&nbsp;</h1>
        </div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!--2-Popper.js-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<!--3-Bootstrap.js-->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/start.js"></script>
<script type="text/javascript" src="js/relatorioSum.js"></script>
</html>