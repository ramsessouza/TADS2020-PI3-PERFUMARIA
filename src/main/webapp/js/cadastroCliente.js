$(function(){
//==================================================================	
//SALVA CLIENTE NO BANCO
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
                url: 'CadastroClienteServlet',//servelet que recebe
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
                    complemento : $('#complemento').val()
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
    });
});