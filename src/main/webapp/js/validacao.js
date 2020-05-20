$(function () {
//==================================================================	
//MASCARAS DOS CAMPOS
//==================================================================
    //para o rg
    $('.mascara-rg').mask('99.999.999-9');
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
        if (!TestaCPF(cpf)) {//se retornar cpf false
            //então
            alert("O CPF " + cpf + " não é válido!")
            $('.mascara-cpf').val("");
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
});