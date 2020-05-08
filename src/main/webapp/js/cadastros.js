$(function(){
//==================================================================	
//MASCARAS DOS CAMPOS
//==================================================================
	//para o rg
	$('.mascara-rg').mask('99.999.999-9');
	//para o cpf
	$('.mascara-cpf').mask('999.999.999-99');
	//para o telefone
	$('.mascara-telefone').mask('99999999999');
	//para o cep
	$('.mascara-cep').mask('99999-999');
	//para o número
	$('.mascara-numero').mask('999999');
        //para decimais
	$(".mascara-decimais").maskMoney({decimal: ".", thousands: ","}).mask('9999999999');
});