<%-- 
    Document   : RelatorioVendas
    Created on : May 7, 2020, 7:09:47 PM
    Author     : Fabio Vieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina" style="text-align: center">
            <h1 class="espacamento">Relatório de Vendas</h1>
            <div class="row">
                <div class="col-lg-8">
                    <label id="textoPadrao">De:</label>
                    <input type="date" class="input">
                    <label id="textoPadrao">Até:</label>
                    <input type="date" class="input">
                    <label id="textoPadrao">Filial:</label>
                    <select class="input">        <option>Selecione</option>
                        <option value="0">Guarulhos</option>
                        <option value="1">São Paulo</option>
                        <option value="2">Tabão da Serra</option>
                    </select>&nbsp;&nbsp;&nbsp;
                    <input class="btn btn-dark" type="submit" value="Pesquisar">
                </div>
                <div class="col-lg-4">
                    <label id="textoPadrao">Total:  R$</label>
                    <label id="textoPadrao">9999.99</label>
                </div>
            </div><hr>
            <h2 class="espacamento">Vendas</h2>
            <table class="table">
                <thead class="thead-dark">
                <th>Nº Venda</th>
                <th>Cliente</th>
                <th>Data</th>
                <th>Qtd. Produtos</th>
                <th>Total</th>
                <th>Vend. Resp.</th>
                </thead>
                <tbody>
                    <tr>
                        <td>0000</td>
                        <td>João</td>
                        <td>01/04/2020</td>
                        <td>5</td>
                        <td>530,00</td>
                        <td>Ana</td>
                    </tr>
                    <tr>
                        <td>0000</td>
                        <td>João</td>
                        <td>01/04/2020</td>
                        <td>5</td>
                        <td>530,00</td>
                        <td>Ana</td>
                    </tr>
                    <tr>
                        <td>00000000</td>
                        <td>Joaaaaaaaaaaaão</td>
                        <td>01/04/2020</td>
                        <td>5555555</td>
                        <td>53550,00</td>
                        <td>Anaaaaaaaaaaaa</td>
                    </tr>
                    <tr>
                        <td>0000</td>
                        <td>João</td>
                        <td>01/04/2020</td>
                        <td>5</td>
                        <td>530,00</td>
                        <td>Ana</td>
                    </tr>
                    <tr>
                        <td>02000</td>
                        <td>João</td>
                        <td>01/04/2020</td>
                        <td>5</td>
                        <td>530,00</td>
                        <td>Ana</td>
                    </tr>
                </tbody>
            </table>
            <hr>
            <h2 class="espacamento">Detalhes da venda</h2>
            <table class="table">
                <thead class="thead-dark">
                <th>Id do Produto</th>
                <th>Nome do Produto</th>
                <th>Quantidade</th>
                <th>Valor Unitário</th>
                <th>Valor por Item</th>
                </thead>
                <tbody>
                    <tr>
                        <td>0000</td>
                        <td>Perfume 1</td>
                        <td>2</td>
                        <td>99.99</td>
                        <td>189.88</td>
                    </tr>
                    <tr>
                        <td>0000</td>
                        <td>Perfume 1</td>
                        <td>2</td>
                        <td>99.99</td>
                        <td>189.88</td>
                    </tr>
                    <tr>
                        <td>0000</td>
                        <td>Perfume 1</td>
                        <td>2</td>
                        <td>99.99</td>
                        <td>189.88</td>
                    </tr>
                    <tr>
                        <td>0000</td>
                        <td>Perfume 1</td>
                        <td>2</td>
                        <td>99.99</td>
                        <td>189.88</td>
                    </tr>
                </tbody>
            </table>
            <hr>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!--2-Popper.js-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <!--3-Bootstrap.js-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/main.js"></script>
</html>
