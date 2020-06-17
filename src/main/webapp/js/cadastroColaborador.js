  
$(function(){
//==================================================================	
//SALVA FUNCIONARIO NO BANCO
//==================================================================
    $('#formulario').on('submit', function(){
        //cancela a ação padrão do clique (permite usar timeout para submeter apos alguns segundos)
        event.preventDefault();
        //verifica se os campos requeridos foram  preenchidos
        if( $('#nome').val() !=="" && $('#dataNascimento').val() !=="" && $('#cpf').val() !=="" &&
            $('#email').val() !=="" && $('#telefone').val() !=="" && $('#logradouro').val() !=="" && $('#numero').val()){
            //função em ajax para mandar o post para o servelet
            $.ajax({
                method: 'POST',//metodo post
                url: 'funcionarioServlet',//servelet que recebe
                data: {//campos do formulario
                    nome : $('#nome').val(), 
                    sexo : $('#sexo').val(), 
                    dataNascimento : $('#dataNascimento').val(),
                    estadoCivil : $('#estadoCivil').val(),
                    status : $('#status').val(),
                    rg : $('#rg').val(),
                    cpf : $('#cpf').val(),
                    email : $('#email').val(),
                    telefone : $('#telefone').val(),
                    estado : $('#estado').val(),
                    cidade : $('#cidade').val(),
                    bairro : $('#bairro').val(),
                    cep : $('#cep').val(),
                    logradouro : $('#logradouro').val(),
                    numero : $('#numero').val(),
                    complemento : $('#complemento').val(),
                    senha : $('#senha').val(),
                    cargo : $('#cargo').val(),
                    filial : $('#filial').val(),
                    departamento : $('#departamento').val()
                }
            }).always(function(response) {//sempre no retorno
                $('#mensagem').text(response);//coloca o texto de retorno na modal
                $('#modalMensagem').modal('show');//mostra modal
            });
        }  
    });
//==================================================================	
//QUANDO FECHAR A MODAL
//==================================================================    
    $('.fechar-modal').on("click",function(){
        //fecha modal e atualiza formulario
        $('#modalMensagem').modal('hide');
        $('#formulario').trigger("reset");
    });
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