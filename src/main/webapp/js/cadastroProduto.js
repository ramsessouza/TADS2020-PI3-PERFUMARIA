$(function(){
//==================================================================	
//SALVA PRODUTO NO BANCO
//==================================================================
    $('#formulario').on('submit', function(){
        //cancela a ação padrão do clique (permite usar timeout para submeter apos alguns segundos)
        event.preventDefault();
        //verifica se os campos requeridos foram  preenchidos
        if( $('#nome').val() !=="" && $('#status').val() !=="" && $('#categoria').val() !=="" &&
            $('#preco').val() !=="" && $('#quantidade').val() !=="" && $('#descricao').val() !==""){
            //função em ajax para mandar o post para o servelet
            $.ajax({
                method: 'POST',//metodo post
                url: 'CadastroProdutoServlet',//servelet que recebe
                data: {//campos do formulario
                    nome : $('#nome').val(), 
                    status : $('#status').val(),
                    categoria : $('#categoria').val(),
                    preco : $('#preco').val(),
                    quantidade : $('#quantidade').val(),
                    descricao : $('#descricao').val()
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
});

