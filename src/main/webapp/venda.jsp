<%-- 
    Document   : venda
    Created on : 30/04/2020, 21:50:51
    Author     : Ramses
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
        <!--Cabeçalho e Barra lateral-->
        <link href="css/start.css" rel="stylesheet">
        <!--Conteudo da página-->
        <link href="css/venda.css" rel="stylesheet">
        <!--Componentes-->
        <link href="css/componentes.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>			
        <title>Perfumaria Muchachos: Registre suas vendas!</title>
    </head>
    <body>
        <!--IMPORT DO CABECALHO E DA BARRA LATERAL-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <!--Linha Geral-->
            <div class="row grade-geral">
                <!--Coluna 1 da pagina-->
                <div class="col-lg-8 col-sm-8 coluna1">
                    <!--Fieldset Produtos-->
                    <fieldset class="produtos">
                        <legend>Produtos</legend>
                        <!--1.Pesquisa de Produtos-->
                        <div class="form-inline pesquisar-produto">
                            <input id="nome-produto" class="form-control" type="text" maxlength="30" placeholder="Pesquise por nome ou categoria">
                            <button id="pesquisa-produto" class="btn btn-dark" type="">Pesquisar 
                                <span class="fas fa-search ml-1"></span>
                            </button>
                        </div>
                        <!--Quantidade e Inserir Produto-->
                        <div class="form-inline inserir-produto">
                            <input id="qtd" class="limite-2 form-control" type="number" min="1" max="99" placeholder="0">
                            <button id="btn-inserir" class="btn btn-dark" type="submit">Inserir 
                                <span class="fas fa-shopping-cart ml-1"></span>
                            </button>
                        </div>
                        <!--2.Tabela de Produtos-->
                        <table id="tb-produtos" class="table table-sm table-secondary table-hover table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th id="id" class="td-id">#</th>
                                    <th id="produto"class="td-produto">PRODUTO</th>
                                    <th id="categoria">CATEGORIA</th>
                                    <th id="qtd">QTD</th>
                                    <th id="valor">VALOR</th>
                                </tr>
                            </thead>
                            <tbody><!--as linhas sao inseridas via Jquery-->
                            </tbody>
                        </table>
                    </fieldset><!--Fim do Fieldset Produtos-->
                    <!--Fieldset Itens venda-->
                    <fieldset class="itens-venda">
                        <legend>Itens Venda</legend>
                        <!--1.Tabela Itens Venda-->
                        <table id="tb-itens-venda" class="table table-sm table-secondary table-hover table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th class="td-id">#</th>
                                    <th class="td-id"><span class="fas fa-pump-soap mr-4"></span></th>
                                    <th class="td-produto">#PRODUTO</th>
                                    <th class="td-qtd">QTD</th>
                                    <th class="td-valor">VALOR</th>
                                    <th class="td-valor">TOTAL</th>
                                    <th class="td-remover">REMOVER</th>
                                </tr>
                            </thead>
                            <tbody><!--as linhas sao inseridas via Jquery-->
                            </tbody>
                        </table>
                    </fieldset><!--Fim do fieldset Itens venda-->
                </div><!--Fim da coluna 1-->

                <!--Coluna 2 da pagina-->	
                <div class="col-lg-4 col-sm-4 coluna2">
                    <!--Fieldset Cliente-->
                    <fieldset class="cliente">
                        <legend>Cliente</legend>
                        <!--1.Pesquisar Cliente-->
                        <div class="form-inline pesquisa-cliente">
                            <input id="cpf-cliente" class="form-control mascara-cpf" placeholder="Ex.: 000.000.000-00">
                            <button id="pesquisar-cliente" class="btn btn-dark">Pesquisar
                                <span class="fas fa-search"></span>
                            </button> 
                        </div>
                        <!--2.Dados do cliente-->
                        <div class="dados-cliente">
                            <input id="cli-id" hidden></input>
                            <div class="form-inline">
                                <p class="legenda mr-1">Nome:</p>
                                <p id="cli-nome"></p>
                            </div>
                            <div class="form-inline">
                                <p class="legenda mr-1">CPF:</p>
                                <p id="cli-cpf"></p>
                            </div>
                        </div>
                    </fieldset><!--Fim do Fieldset Cliente-->
                    <!--Fieldset Finalizar Venda-->
                    <fieldset class="finalizar-compra">
                        <legend>Finalizar Compra</legend>
                        <!--Finalizar Containner-->
                        <div class="finalizar-container">
                            <!--1.Total da compra-->
                            <div>
                                <h2>Total da Compra</h2>
                                <h2 id="total-compra">R$ 0,00</h2>
                            </div>
                            <!--2.Inputs valores-->
                            <div>
                                <!--Pagamento dinheiro-->
                                <div class="input-group mb-2 mr-sm-2">
                                    <div class="input-group-prepend ">
                                        <div class="input-group-text"><span>R$</span></div>
                                    </div>
                                    <input id="pag-din"  class="mascara-decimais form-control mr-0" placeholder="PAGAMENTO EM DINHEIRO">
                                </div>
                                <!--Pagamento débito-->
                                <div class="input-group mb-2 mr-sm-2">
                                    <div class="input-group-prepend ">
                                        <div class="input-group-text"><span>R$</span></div>
                                    </div>
                                    <input id="pag-deb" class="mascara-decimais form-control mr-0" placeholder="PAGAMENTO EM DÉBITO">
                                </div>
                                <!--Pagamento crédito-->
                                <div class="form-row">
                                    <div class="col-lg-9 col-sm-9">
                                        <div class="input-group mb-2 mr-sm-2">
                                            <div class="input-group-prepend ">
                                                <div class="input-group-text"><span>R$</span></div>
                                            </div>
                                            <input id="pag-cred" class="mascara-decimais form-control mr-0" placeholder="PAGAMENTO EM CRÉDITO">
                                        </div>
                                    </div>
                                    <div id="tot-parc" class="col-lg-3 col-sm-3">
                                        <div class="dropdown mb-2 parcela">
                                            <select class="form-control">
                                                <option value=""></option>
                                                <option value="1">1X</option>
                                                <option value="2">2X</option>
                                                <option value="3">3X</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <!--Valor desconto-->
                                <div class="input-group mb-2 mr-sm-2 place-branco">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text"><span>R$</span></div>
                                    </div>
                                    <input id="val-desc" class="mascara-decimais form-control bg-primary mr-0 text-white" placeholder="VALOR DE DESCONTO">
                                </div>
                                <!--Total troco-->
                                <div class="input-group mb-2 mr-sm-2 place-preto">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text"><span>R$</span></div>
                                    </div>
                                    <input id="tot-troc" class="form-control bg-warning mr-0 text-black" placeholder="TOTAL TROCO" disabled>
                                </div>
                            </div>
                            <!--3.Botões-->
                            <div>
                                <button id="cancelar-venda" class="btn btn-danger btn-block">CANCELAR
                                    <span class="fas fa-times ml-1"></span>
                                </button>
                                <button id="venda-proximo" class="btn btn-success btn-block">PRÓXIMO
                                    <span class="fas fa-arrow-right ml-1"></span>
                                </button>
                            </div>
                        </div><!--Fim do finalizar Container-->
                    </fieldset><!--Fim do Fieldset Finalizar Venda-->
                </div><!--Fim coluna2-->
            </div><!--Fim da Linha Geral-->
        </div><!--Fim do conteudo da pagina-->
        
        <!--MODAL-->
        <div class="modal fade" id="modalMensagem" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <!--HEADER-->
                    <div class="modal-header">
                        <!--mensagem-->
                        <h5 id="h5-padrao" class="modal-title">Mensagem</h5>
                        <h5 id="h5-finalizar" class="modal-title">Resumo da venda:</h5>
                        <!--botao-->
                        <button type="button" class="close fechar-modal"><!--data-dismiss="modal"-->
                            <span class="fas fa-times"></span>
                        </button>
                    </div><!--FIM HEADER-->
                    <!--BODY-->
                    <div class="modal-body">
                        <!--div padrao-->
                        <div id="padrao-body">
                            <p id="mensagem"></p>
                        <p hidden id="registre-cliente">Faça o registro agora clicando<a href="cadastroCliente.jsp"> aqui</a>.</p>
                        </div>
                        <!--div finalizou venda-->
                        <div id="finalizar-body" class="container-fluid">
                            <!--funcionario-->
                            <div class="form-inline">
                                <label class="form-inline bold mr-1">Funcionario:</label>
                                <label id="venda-funcionario-nome" class="form-inline mr-1">${sessionScope.funcionarioSessao.nome}</label>
                                <input id="venda-funcionario-id" value="${sessionScope.funcionarioSessao.id}" class="form-inline" size="2" disabled hidden></input>
                            </div> 
                            <!--cliente nome-->
                            <div class="form-inline">
                                <label class="form-inline bold mr-1">Cliente:</label>
                                <label id="venda-cliente-nome" class="form-inline"></label>
                            </div> 
                            <!--cliente cpf-->
                            <div class="form-inline mb-2">
                                <label class="form-inline bold mr-1">CPF do Cliente:</label>
                                <label id="venda-cliente-cpf" class="form-inline mr-1"></label>
                                <label id="venda-cliente-id" class="form-inline" hidden></label>
                            </div> 
                            <!--data-->
                            <div class="form-inline">
                                <label class="form-inline bold mr-1">Data:</label>
                                <label id="venda-data" class="form-inline"></label>
                            </div>
                            <!--quantidade itens-->
                            <div class="form-inline mb-2">
                                <label class="form-inline bold mr-1">Total de itens:</label>
                                <label id="venda-itens" class="form-inline"></label>
                            </div> 
                            <!--total da compra-->
                            <div id="div-total-compra" class="form-inline">
                                <label class="form-inline bold mr-1">Total da compra: </label>
                                <label id="venda-total" class="form-inline"></label>
                            </div> 
                            <!--pago dinheiro-->
                            <div class="form-inline">
                                <label class="form-inline bold mr-1">Pago em dinheiro:</label>
                                <label id="venda-dinheiro" class="form-inline"></label>
                            </div>
                            <!--pago debito-->
                            <div class="form-inline">
                                <label class="form-inline bold mr-1">Pago em debito:</label>
                                <label id="venda-debito" class="form-inline"></label>
                            </div> 
                            <!--pago credito-->
                            <div class="form-inline">
                                <label class="form-inline bold mr-1">Pago em crédito:</label>
                                <label id="venda-credito" class="form-inline"></label>
                            </div> 
                            <!--parcelas-->
                            <div class="form-inline">
                                <label class="form-inline bold mr-1">Parcelas:</label>
                                <label id="venda-parcelas" class="form-inline"></label>
                            </div>
                            <!--valor desconto-->
                            <div class="form-inline bg-primary label-white">
                                <label class="form-inline bold mr-1">Desconto:</label>
                                <label id="venda-desconto" class="form-inline"></label>
                            </div> 
                            <!--valor troco-->
                            <div class="form-inline bg-warning label-black">
                                <label class="form-inline bold mr-1">Troco:</label>
                                <label id="venda-troco" class="form-inline"></label>
                            </div> 
                        </div><!--fim div finalizou venda-->
                    </div><!--FIM BODY-->
                    <!--FOOTER-->
                    <div class="modal-footer">
                        <!--footer padrao-->
                        <div id="padrao-footer">
                            <button type="button" class="btn btn-danger btn-sm fechar-modal">Okay</button>
                        </div>
                        <!--footer excluir-->
                        <div id="excluir-footer" class="container-fluid">
                            <input hidden id="idItenExcluir"></input>
                            <input hidden id="valorItenExluir"></input>
                            <div class="row">
                                <div class="col-md-6">
                                    <button type="button" class="btn btn-primary btn-block fechar-modal">Não</button>
                                </div>
                                <div class="col-md-6">
                                    <button id="excluir-item" type="button" class="btn btn-danger btn-block">Sim</button>
                                </div>
                            </div>
                        </div>
                        <!--footer finalizar-->
                        <div id="finalizar-footer" class="container-fluid">
                            <div class="row">
                                <div class="col-md-6">
                                    <button class="btn btn-danger btn-block fechar-modal">MODIFICAR
                                        <span class="fas fa-edit ml-1"></span>
                                    </button>
                                </div>
                                <div class="col-md-6">
                                    <button id="venda-finalizar" class="btn btn-success btn-block">FINALIZAR
                                        <span class="fas fa-check ml-1"></span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div><!--FIM FOOTER-->
                </div>
            </div>
        </div><!--FIM FIM MODAL-->
        <!--SCRIPTS-->
        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!--4-Mask Money Plugin-->
        <script src="https://cdn.rawgit.com/plentz/jquery-maskmoney/master/dist/jquery.maskMoney.min.js"></script>
        <!--5-Mask Plugin-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.min.js"></script>
        <!--6-Específica da página-->
        <script type="text/javascript" src="js/venda.js"></script>
        <script type="text/javascript" src="js/validacao.js"></script>
    </body>
</html>
