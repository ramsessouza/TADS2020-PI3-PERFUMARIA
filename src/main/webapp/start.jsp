<%-- 
    Document   : start
    Created on : 30/04/2020, 21:49:56
    Author     : Ramses e Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Bem vindo ao sistema!</title>
        <!--Específica da página-->
        <link href="css/start.css" rel="stylesheet">
    </head>
    <body>
        <!--import do cabeçalho e barra lateral-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <img id="img" src="img/perfume(25).jpg" height="600" width="600">
            <div id="produtos-muchachos">
                <h1>Produtos Muchachos Perfumaria</h1>
            </div>
        </div>

        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
    <script>
        var i = 0;
        setInterval(fadeDivs, 4000);

        function fadeDivs() {
            i = i < 25 ? i : 0;
       
            $('#img').fadeOut(500, function () {
                $(this).attr('src', "img/perfume("+i+").jpg").fadeIn(500);
            })
            i++;
        }
    </script>
</html>