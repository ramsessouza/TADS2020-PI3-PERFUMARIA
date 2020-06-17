$(function () {
//==================================================================	
//MASCARAS DOS CAMPOS
//==================================================================
    //para o telefone
    $('.mascara-telefone').mask('99999999999');
    //para o cep
    $('.mascara-cep').mask('99999-999');
    //para o número
    $('.mascara-numero').mask('999999');
    //para decimais
    $(".mascara-decimais").maskMoney({decimal: ".", thousands: ","}).mask('9999999999');

    //limita campos integer para 2 caracteres
    $(".limite-2").on('keydown', function (e) {
        if ($(this).val().length >= 2 && e.keyCode !== 8 && e.keyCode !== 9) {
            return false;
        }
    });
    
    //para o cpf
    $('.mascara-cpf').mask('999.999.999-99').focusout(function () {
        var cpf = $(this).val().replace("-", "").replace(/\./g, '');
        if(cpf === ""){
            return
        }
        if (!TestaCPF(cpf)) {//se retornar cpf false
            //então
            $('#mensagem-cpf').text("O CPF não é válido!");//coloca o texto na label
            $('.mascara-cpf').val("");
        }
    });
//==================================================================	
//AO DAR FOCU NO INPUT DO CPF
//==================================================================
    $('.mascara-cpf').focus(function () {
        //console.log($('#mensagem-cpf').text());
        if($('#mensagem-cpf').text() !== ""){//se tiver algum aviso
            $('#mensagem-cpf').text("");//limpa o aviso
        }
    });
//==================================================================	
//Função para validar CPF
//==================================================================        
    function TestaCPF(strCPF) {
        var Soma;
        var Resto;
        Soma = 0;
        if (strCPF == "00000000000")
            return false;

        for (i = 1; i <= 9; i++)
            Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
        Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11))
            Resto = 0;
        if (Resto != parseInt(strCPF.substring(9, 10)))
            return false;

        Soma = 0;
        for (i = 1; i <= 10; i++)
            Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
        Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11))
            Resto = 0;
        if (Resto != parseInt(strCPF.substring(10, 11)))
            return false;
        return true;
    }
//==================================================================	
//VERIFICA SE JA TEM CLIENTE NO BANCO
//==================================================================
    $('.cpf-cliente').keyup(function () {
        if($('#mensagem-cpf').text() !== ""){//se tiver algum aviso
            $('#mensagem-cpf').text("");//limpa o aviso
        }
        
        if($(this).val().length === 14){//se digitar todos os digitos dos cpf 
            //função em ajax para mandar o post para o servelet
            $.ajax({//pesquisa o cliente por cpf
                method: 'POST',//metodo post
                url: 'ConsultarClienteServlet',//servelet que recebe
                data: {
                    cpf : $(this).val(),
                    acao : "pesquisacpf"
                }//dados a serem enviados
            }).always(function(responseJson) {
                if(responseJson.responseText !== "Não encontrado!"){//se encontrar
                   $('#mensagem-cpf').text("CPF já cadastrado!");//coloca o texto na label
                   $('.cpf-cliente').val("");
                }
            });
       }
    });
//==================================================================	
//VERIFICA SE JA TEM FUNCIONARIO NO BANCO
//==================================================================
    $('.cpf-funcionario').keyup(function () {
        if($('#mensagem-cpf').text() !== ""){//se tiver algum aviso
            $('#mensagem-cpf').text("");//limpa o aviso
        }
        
        if($(this).val().length === 14){//se digitar todos os digitos dos cpf 
            //função em ajax para mandar o post para o servelet
            $.ajax({//pesquisa o cliente por cpf
                method: 'POST',//metodo post
                url: 'buscarFuncionarioServlet',//servelet que recebe
                data: {
                    cpf : $(this).val()
                }//dados a serem enviados
            }).always(function(responseJson) {
                if(responseJson.responseText !== "Não encontrado!"){//se encontrar
                   $('#mensagem-cpf').text("CPF já cadastrado!");//coloca o texto na label
                   $('.cpf-funcionario').val("");
                }
            });
       }
    });
});