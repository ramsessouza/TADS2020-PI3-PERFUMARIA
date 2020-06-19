<%-- 
    Document   : RelatorioVendas
    Created on : May 7, 2020, 7:09:47 PM
    Author     : Fabio Vieira
    Alteracao  : Ramses Souza 19/06/2020
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
        <!--Componentes-->
        <link href="css/componentes.css" rel="stylesheet">
        <link href="css/relatorios.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>			
        <title>Perfumaria Muchachos: Relatório de Vendas</title>
    </head>
    <body>
        <!--IMPORT DO CABECALHO E DA BARRA LATERAL-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <!--Linha 1 - Nome e Total da pesquisa-->
            <div class="form-inline" id="linha1">
                <div class="col-md-8 col-sm-8 relatorio-vendas">
                    <h1>Relatório de Vendas</h1>
                </div>
                <div class="col-md-4 col-md-4 form-inline total-vendas">
                    <label id="textoPadrao">TOTAL DAS VENDAS:</label>
                    <label id="totalPesquisa" class="mascara-decimais ml-1" size="5px">0</label>
                </div>
            </div>
            <form action="RelatoriosServlet" method="POST">
                <!--Linha 2 - com campos de pesquisa-->
                <div class="row campos">
                    <!--Nome do CLIENTE-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label class="label-campos">NOME DO CLIENTE</label>
                            <input type="text" class="form-control" name="cliente" maxlength="50" placeholder="Nome do cliente">
                        </div>
                    </div>
                    <!--Data DE-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label class="label-campos">DATA INICIAL</label>
                            <input name="dataDe" id="dataDe" type="date" class="form-control" >
                        </div>
                    </div>
                    <!--Data PARA-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label class="label-campos">DATA FINAL</label>
                            <input name="dataPara" id="dataPara" type="date" class="form-control">
                        </div>  
                    </div>
                    <!--Data PARA-->
                    <div class="dropdown col-md-2 col-sm-2">
                        <div class="form-group">
                            <label class="label-campos">FILIAL</label>
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
                                <option value="sao paulo">São Paulo</option>
                                <option value="sergipe">Sergipe</option>
                                <option value="tocantins">Tocantins</option>
                            </select>
                        </div>
                    </div>
                    <!--Categoria-->
                    <div class="dropdown col-md-2 col-sm-2">
                        <div class="form-group">
                            <label class="label-campos">CATEGORIA</label>
                            <select name="categ" id="categ" class="form-control">
                                <option value="todas">Todas</option>
                                <option value="beleza">Beleza</option>
                                <option value="cosmeticos">Cosmeticos</option>
                                <option value="perfumes">Perfumes</option>
                                <option value="utensilios">Utensilios</option>
                            </select>
                        </div>
                    </div>
                    <!--Botão de pesquisa-->
                    <div class="col-md-2 col-sm-2">
                        <label id="label-botao">BOTAO PESQUISAR</label>
                        <button class="btn btn-dark btn-block" type="submit">Pesquisar
                            <span class="ml-1 fas fa-search"></span>
                        </button>
                    </div>
                </div>
            </form>
            <div class="tabela">
                <table id="tableVendas" class="table table-sm table-secondary table-hover table-striped">   
                    <thead class="thead-dark">
                        <tr>
                            <th class="td-id">#</th>
                            <th class="td-nome">FUNCIONARIO</th>
                            <th>CLIENTE</th>
                            <th class="td-data">DATA</th>
                            <th>ITENS</th>
                            <th>TOTAL</th>
                            <th>DINHEIRO</th>
                            <th>DEBITO</th>
                            <th>CREDITO</th>
                            <th>PARCELAS</th>
                            <th>DESCONTO</th>
                            <th>TROCO</th>
                            <th>FILIAL</th>
                        </tr>
                    </thead>        
                    <c:forEach var="v" items="${vendas}">
                        <tr class="linha">
                            <td class="td-id" name="id">${v.id}</td>
                            <td class="td-nome">${v.vend_resp}</td>
                            <td>${v.cliente}</td>
                            <td class="td-data">${v.data}</td>
                            <td>${v.qtd_itens}</td>
                            <td class="itemPreco">${v.total}</td>
                            <td >${v.pag_deb}</td>
                            <td >${v.pag_din}</td>
                            <td >${v.pag_cred}</td>
                            <td >${v.parcelas}</td>
                            <td >${v.val_desc}</td>
                            <td >${v.troco}</td>
                            <td>${v.filial}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            </div>
            <!--MODAL DETALHES-->
            <div class="modal fade modal" id="modalDetalhes" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Detalhes da venda</h5>
                            <button type="button" class="close fechar-modal">
                                <span class="fas fa-times"></span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="dropdown col-md-4 col-sm-4" id="filtros">
                                <div class="form-group">
                                    <label>Categoria</label>
                                    <select name="categoria" id="categoria" class="form-control">
                                        <option value="todas">Todas</option>
                                        <option value="beleza">Beleza</option>
                                        <option value="cosmeticos">Cosmeticos</option>
                                        <option value="perfumes">Perfumes</option>
                                        <option value="utensilios">Utensilios</option>
                                    </select>
                                </div>
                            </div>
                            <table class="table table-sm table-secondary table-hover table-striped" id="detalheTabela">
                                <thead class="thead-dark">
                                    <th>PRODUTO</th>
                                    <th>CATEGORIA</th>
                                    <th>QTD</th>
                                    <th>VALOR</th>
                                    <th>TOTAL</th>
                                </thead>
                                <tbody
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger btn-sm fechar-modal">
                                <span class="fas fa-times mr-2"></span>Fechar
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!--MODAL ERRO-->
            <div class="modal fade modal" id="modalErro" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Mensagem</h5>
                            <button type="button" class="close fechar-modal">
                                <span class="fas fa-times"></span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p id="mensagem"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger btn-sm fechar-modal">
                                <span class="fas fa-times mr-2"></span>Fechar
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--1-Jquery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/relatorios.js"></script>
    </body>
</html>