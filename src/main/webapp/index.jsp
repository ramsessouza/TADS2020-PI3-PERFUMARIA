<%-- 
    Document   : index
    Created on : 30/04/2020, 21:44:48
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
        <!--Específica da Página-->
        <link href="css/index.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Seja bem vindo!</title>
    </head>
	
    <body class="corpo">
        <div class="container-fluid">
            <!--LINHA 1 - CABEÇALHO-->
            <div class="col-md-12 cabecalho">
                <h1>Bem vindo!</h1>	
            </div>

            <!--LINHA 2 - LOGO-->
            <div class="col-md-12">
                <img id="logo" src="img/logo-dark.png" alt="Logo Muchachos Perfumaria">
            </div>

            <!--LINHA 3 - FORMULARIO-->
            <div class="col-lg-4 offset-lg-4">
                <!--FORM-->
                <form id="formulario" method="post" action="LoginServlet">
                    <div class="form-group containner">
                        <!--INPUT LOGIN-->						
                        <div class="input-group mb-2 mr-sm-2">
                            <div class="input-group-prepend">
                            <div class="input-group-text"><span class="fas fa-user"></div>
                        </div>
                            <input class="form-control" type="email" name="email" placeholder="E-mail" required>
                        </div>
                        <!--INPUT SENHA-->
                        <div class="input-group mb-2 mr-sm-2">
                            <div class="input-group-prepend ">
                            <div class="input-group-text"><span class="fas fa-lock"></span></div>
                        </div>
                            <input class="form-control" type="password" name="senha" placeholder="Senha" required>
                        </div>
                        <!--BOTAO ENTRAR-->
                        <button class="btn btn-dark btn-block" type="submit" id="entrar">Login</button>
                    </div>
                </form>
            </div>

            <!--LINHA 4 - RODAPÉ-->
            <div class="col-md-4 rodape">
              <p>Copyright &copy; 2020 - By Muchachos Perfumaria</p>
            </div>
        </div>

        <!--SCRIPTS-->
        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!--4-Específica da página-->
        <script type="text/javascript" src="js/index.js"></script> 
    </body>
</html>

