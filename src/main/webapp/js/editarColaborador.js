  
$(function(){
//==================================================================	
//GERA EMAIL DO FUNCIONARIO COM BASE NO NOME E CPF
//==================================================================     
    $('.gerador-email').focusout(function () {
        nome = $('#nome').val().substr(0,3).toLowerCase().replace(" ", "");//pega as primeiras 3 letras do nome
        espaco = $('#nome').val().lastIndexOf(" ");//encontra o ultimo espaco
        sobrenome = $('#nome').val().substr(espaco+1).toLowerCase();//pega apenas sobrenome
        cpf = $('#cpf').val().substr(0,3);//pega os 3 primeiros digitos do cpf
        
        if(espaco != -1){//se tiver sobrenome 
            $('#email').val(sobrenome+nome+cpf+"@muchachos.com");//coloca email gerado no input com sobrenome
        }else{//se nao tiver sobrenome
            $('#email').val(nome+cpf+"@muchachos.com");//coloca email gerado no input sem sobrenome
        }
    });
});