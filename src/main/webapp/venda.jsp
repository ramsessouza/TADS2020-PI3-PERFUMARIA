<%-- 
    Document   : venda
    Created on : 30/04/2020, 21:50:51
    Author     : Ramses
--%>

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
		<!--CABEÇALHO-->
		<div class="container-fluid">
			<div class="row cabecalho">
				<div class="col-lg-2 col-sm-2"><!--BUTTON TOGGLE-->
					<button id="hamburger" type="button" class="btn btn-outline-dark"><span class="fas fa-bars"></span></button>
				</div>
				<div class="col-lg-3 col-sm-3"><!--LOGO CABEÇALHO-->
					<!--Colorir logo efeito em jquery - usa-se o id #logocab-->
					<img id="logocab" src="img/grupo-2.png" alt="Logo Muchachos Perfumaria">
				</div>
				<div class="col-lg-3 col-sm-3"><!--HORA E DATA-->
					<h1 id="calendario"></h1><!--Data e calendario feito em jquery - usa-se o id #calendario-->
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
				<li><a class="item-linha" href="#"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
				<li><a class="item-linha" href="#"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
				<li><a class="item-linha" href="#"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
				<p>Marketing</p>
				<li><a class="item-linha" href="#"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
				<li><a class="item-linha" href="#"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
				<li><a class="item-linha" href="#"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
				<p>Tecnologia da Informação</p>
				<li><a class="item-linha" href="#"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
				<li><a class="item-linha" href="#"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
				<p>Recursos Humanos</p>
				<li><a class="item-linha" href="#"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
				<p>Gerência</p>
				<li><a class="item-linha" href="#"><span class="fas fa-chart-line mr-3"></span> Relatório Filial</a></li>
				<p>Diretoria</p>
				<li><a class="item-linha" href="#"><span class="fas fa-chart-bar mr-3"></span> Relatório Geral</a></li>
			</ul>
		</div>
		<!--CONTEUDO DA PAGINA-->
		<!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
		<div id="conteudo-pagina" class="container-fluid conteudo-pagina">
			<!--Linha Geral-->
			<div class="row grade-geral">
				<!--Coluna 1 da pagina-->
				<div class="col-lg-8 col-sm-8 coluna1">
					
					<!--Escolher produtos-->
					<fieldset class="produtos">
						<legend>Produtos</legend>
						<!--1.Pesquisa de Produtos-->
						<div class="form-inline pesquisar-produto">
							<input class="form-control" type="text" maxlength="30" placeholder="Pesquise pelo nome">
							<button class="btn btn-dark" type="submit">Pesquisar 
								<span class="fas fa-search"></span>
							</button>
						</div>
						<!--Quantidade e Inserir Produto-->
						<div class="form-inline inserir-produto">
							<input class="limite-2 form-control" type="number" min="1" max="99" placeholder="0">
							<button id="btn-inserir" class="btn btn-dark" type="submit">Inserir 
								<span class="fas fa-shopping-cart"></span>
							</button>
						</div>
						
						<!--2.Tabela de Produtos-->
						<table class="table table-sm table-secondary table-hover table-striped">
							<thead class="thead-dark">
								<tr>
									<th class="td-id">#</th>
									<th class="td-produto">Produto</th>
									<th >Categoria</th>
									<th >Qtd</th>
									<th >Valor</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="td-id">1</td>
									<td class="td-produto">Shampoo Elseve</td>
									<td >Para o cabelo</td>
									<td >200</td>
									<td >R$3,50</td>
								</tr>
								<tr>
									<td class="td-id">4</td>
									<td class="td-produto">Condicionador Elseve</td>
									<td >Para o cabelo</td>
									<td >100</td>
									<td >R$20,60</td>
								</tr>
								<tr>
									<td class="td-id">3</td>
									<td class="td-produto">Shampoo Loreal</td>
									<td >Para o cabelo</td>
									<td >33</td>
									<td >R$7,80</td>
								</tr>
								<tr>
									<td class="td-id">5</td>
									<td class="td-produto">Condicionador Loreal</td>
									<td >Para o cabelo</td>
									<td >33</td>
									<td >R$7,80</td>
								</tr>
								<tr>
									<td class="td-id">6</td>
									<td class="td-produto">Perfum 212 Carolina Herrera</td>
									<td >Perfumes</td>
									<td >33</td>
									<td >R$7,80</td>
								</tr>
								<tr>
									<td class="td-id">7</td>
									<td class="td-produto">Sabonete Norma Derm</td>
									<td >Coesméticos</td>
									<td >33</td>
									<td >R$7,80</td>
								</tr>
								<tr>
									<td class="td-id">8</td>
									<td class="td-produto">Sabonete Norma Derm</td>
									<td >Coesméticos</td>
									<td >33</td>
									<td >R$7,80</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
			
					<!--Itens venda-->
					<fieldset class="itens-venda">
						<legend>Itens Venda</legend>
						<!--1.Tabela Itens Venda-->
						<table class="table table-sm table-secondary table-hover table-striped">
							<thead class="thead-dark">
								<tr>
									<th class="td-id">#</th>
									<th class="td-id"><span class="fas fa-pump-soap mr-4"></span></th>
									<th class="td-produto">#Produto</th>
									<th class="td-qtd">Qtd</th>
									<th class="td-valor">Valor Unitário</th>
									<th class="td-valor">Valor Total</th>
									<th class="td-remover">Remover</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="td-id">1</td>
									<td class="td-id">23</td>
									<td class="td-produto">Shampoo Elseve</td>
									<td class="td-qtd">1</td>
									<td class="td-valor">R$23,50</td>
									<td class="td-valor">R$23,50</td>
									<td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td>
								</tr>
								<tr>
									<td class="td-id">2</td>
									<td class="td-id">45</td>
									<td class="td-produto">Condicionador Elseve</td>
									<td class="td-qtd">1</td>
									<td class="td-valor">R$24,23</td>
									<td class="td-valor">R$24,23</td>
									<td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td>
								</tr>
								<tr>
									<td class="td-id">3</td>
									<td class="td-id">12</td>
									<td class="td-produto">Sabonete Normaderm</td>
									<td class="td-qtd">1</td>
									<td class="td-valor">R$32,50</td>
									<td class="td-valor">R$32,50</td>
									<td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td>
								</tr>
								<tr>
									<td class="td-id">4</td>
									<td class="td-id">64</td>
									<td class="td-produto">Perfume Ninja</td>
									<td class="td-qtd">1</td>
									<td class="td-valor">R$413,50</td>
									<td class="td-valor">R$413,50</td>
									<td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td>
								</tr>
								<tr>
									<td class="td-id">5</td>
									<td class="td-id">19</td>
									<td class="td-produto">Papel de Cu</td>
									<td class="td-qtd">10</td>
									<td class="td-valor">R$3,50</td>
									<td class="td-valor">R$35,00</td>
									<td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td>
								</tr>
								<tr>
									<td class="td-id">6</td>
									<td class="td-id">19</td>
									<td class="td-produto">Papel de Cu</td>
									<td class="td-qtd">10</td>
									<td class="td-valor">R$3,50</td>
									<td class="td-valor">R$35,00</td>
									<td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td>
								</tr>
								<tr>
									<td class="td-id">7</td>
									<td class="td-id">19</td>
									<td class="td-produto">Papel de Cu</td>
									<td class="td-qtd">10</td>
									<td class="td-valor">R$3,50</td>
									<td class="td-valor">R$35,00</td>
									<td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</div><!--Fim da coluna 1-->

				<!--Coluna 2 da pagina-->	
				<div class="col-lg-4 col-sm-4 coluna2">
							
					<!--Cliente-->
					<fieldset class="cliente">
						<legend>Cliente</legend>
						<!--1.Pesquisar Cliente-->
						<div class="form-inline pesquisa-cliente">
							<input class="form-control" type="text" patern="\d{3}.\d{3}.\d{3}-\d{2}" placeholder="Ex.: 000.000.000-00">
							<button class="btn btn-dark" type="submit">Pesquisar
								<span class="fas fa-search"></span>
							</button> 
						</div>
						
						<!--2.Dados do cliente-->
						<div class="dados-cliente">
							<div class="form-inline">
								<p class="legenda mr-1">Nome:</p>
								<p>JOSÉ MAURÍCIO DE SOUZA</p>
							</div>
							<div class="form-inline">
								<p class="legenda mr-1">CPF:</p>
								<p>110.558.998.40</p>
							</div>
						</div>
					</fieldset>
					
					<!--Finalizar-->
					<fieldset class="finalizar-compra">
						<legend>Finalizar Compra</legend>
						<!--Finalizar Containner-->
						<div class="finalizar-container">
							<!--1.Total da compra-->
							<div>
								<h3>Total da Compra</h3>
								<h2>R$ 1024,00</h2>
							</div>
							<!--2.Inputs valores-->
							<div>
								<!--Pagamento débito-->
								<div class="input-group mb-2 mr-sm-2">
									<div class="input-group-prepend ">
									<div class="input-group-text"><span>R$</span></div>
								</div>
									<input class="moeda form-control mr-0" placeholder="PAGAMENTO EM DÉBITO">
								</div>
								<!--Pagamento dinheiro-->
								<div class="input-group mb-2 mr-sm-2">
									<div class="input-group-prepend ">
									<div class="input-group-text"><span>R$</span></div>
								</div>
									<input class="moeda form-control mr-0" placeholder="PAGAMENTO EM DINHEIRO">
								</div>
								<!--Pagamento crédito-->
								<div class="form-row">
									<div class="col-lg-9 col-sm-9">
										<div class="input-group mb-2 mr-sm-2">
											<div class="input-group-prepend ">
											<div class="input-group-text"><span>R$</span></div>
										</div>
											<input class="moeda form-control mr-0" placeholder="PAGAMENTO EM CRÉDITO">
										</div>
									</div>
									<div class="col-lg-3 col-sm-3">
										<div class="dropdown mb-2 parcela">
											<select id="EstadoCivil" class="form-control">
											<option value="Casado">1X</option>
											<option value="Solteiro">2X</option>
											<option value="Divorciado">3X</option>
											</select>
										</div>
									</div>
								</div>
								<!--Valor desconto-->
								<div class="input-group mb-2 mr-sm-2 place-branco">
									<div class="input-group-prepend">
									<div class="input-group-text"><span>R$</span></div>
								</div>
									<input class="moeda form-control bg-primary mr-0 text-white" placeholder="VALOR DE DESCONTO">
								</div>
								<!--Total troco-->
								<div class="input-group mb-2 mr-sm-2 place-branco">
									<div class="input-group-prepend">
									<div class="input-group-text"><span>R$</span></div>
								</div>
									<input class="form-control bg-warning mr-0 text-white" placeholder="TOTAL TROCO" disabled>
								</div>
							</div>
							<!--3.Botões-->
							<div>
								<button class="btn btn-danger btn-block" type="submit">CANCELAR
									<span class="fas fa-times"></span>
								</button>
								<button class="btn btn-success btn-block" type="submit">FINALIZAR
									<span class="fas fa-check"></span>
								</button>
							</div>
						</div><!--Fim finalizar Container-->
					</fieldset>
						
				</div><!--Fim coluna2-->
			</div><!--Fim da Linha Geral-->
		</div><!--Fim do conteudo da pagina-->

		<!--SCRIPTS-->
		<!--1-jQuery.js-->
    	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    	<!--2-Popper.js-->
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	    <!--3-Bootstrap.js-->
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	    <script src="https://igorescobar.github.io/jQuery-Mask-Plugin/js/jquery.mask.min.js"></script>
		<!--4-Mask Money Plugin-->
    	<script src="https://cdn.rawgit.com/plentz/jquery-maskmoney/master/dist/jquery.maskMoney.min.js"></script>
	    <!--5-Específica da página-->
	    <script type="text/javascript" src="js/start.js"></script>
	    <script type="text/javascript" src="js/venda.js"></script>

	</body>
</html>
