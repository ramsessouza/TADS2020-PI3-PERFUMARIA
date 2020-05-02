<%-- 
    Document   : cadastroProduto
    Created on : 01/05/2020, 19:29:31
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Muchachos</title>
<link rel="shortcut icon" href="imagem/muchachos.png">
<link rel="stylesheet" href="css/estilobootstrap.css">
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/cadastroProduto.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
	<header class="layout-cabecalho">
	
		<div class="container">
			<nav class="navegacao  ">
				<a href="index.html"><img src="img/muchachos.png"
					title="HOME" width="60" height="60" alt="Muchachos" /></a>
			</nav>
		</div>
	</header>

	<div class="container">
	<form action="produtoServlet" method="post">
	
	<h1 class="titulo-formulario">Cadastro de Produto</h1> 

				<div class="row">
				<div class="col-sm-8">
					<div class="grupo-entrada">
						<label for="nomeDoProduto">Nome do Produto</label>
						 <input id="nomeDoProduto" name="nomeDoProduto" type="text" class="campo" required >
					</div>
				</div>

				</div>
				
				<div class="row">
				<div class="col-sm-4">
					<div class="grupo-entrada">
						<label for="Preco">Preço</label>
						 <input id="Preco" name="Preco" type="number" class="campo" required >
					</div>
				</div>

				<div class="col-sm-4">
					<div class="grupo-entrada">
						<label for="Quantidade">Quantidade</label>
						 <input id="Quantidade" name="Quantidade" type="number" class="campo" required >
					</div>
				</div>
				</div>

				<div class="row">
					<div class="col-sm-8">
					<div class="grupo-entrada">
						<label for="descricao">Descrição</label>
						<textarea id="descricao" name="descricao" type="text" class="area" required></textarea>
					</div>
				</div>
				</div>

				<div class="row">
				<div class="col-sm-8">
					<div class="grupo-entrada">
						<label for="categoria">Categoria</label> 
						<select id="categoria" name="categoria" class="campo" required>
		                    <option>Selecione</option>
		                    <option value="Beleza">Beleza</option>
                            <option value="Cosméticos">Cosmeticos</option>
                            <option value="Perfumes">Perfumes</option>
                            <option value="Utensílios">Utensilios</option>
						</select>
					</div>
				</div>
				</div>


				<div class="row">
				<div class="col-sm-3">
					<div class="grupo-entrada">
						<div style="text-align: left; margin-top: 20px">
							<input type="submit" value="Salvar" class="botao-tabela">
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="grupo-entrada">
						<div style="text-align: left; margin-top: 20px">
							<input type="reset" value="Cancelarr" class="botao-tabela">
						</div>
					</div>
				</div>
			</div>
		</form>
	  </div>

	<footer class="layout-rodape">
		<div class="container">
			<p>&copy; Muchachos. Todos os direitos reservados.</p>
		</div>
	</footer>
</body>
</html>
