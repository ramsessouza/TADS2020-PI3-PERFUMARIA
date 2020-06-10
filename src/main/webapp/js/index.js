$(function(){
//==================================================================	
//EFEITO AO PASSAR MOUSE NO LOGO
//==================================================================
    $('#logo').mouseenter(function(){
            $(this).attr("src","img/logo-colorido.png");
    }).mouseout(function(){
            $(this).attr("src","img/logo-dark.png");
    });
//==================================================================	
//AO DAR FOCU NOS INPUTS SOME MENSAGEM DE ERRO
//==================================================================
    $('#email').focus(function () {
        $('#mensagem-erro').text("");
    });
    $('#senha').focus(function () {
        $('#mensagem-erro').text("");
    });
});