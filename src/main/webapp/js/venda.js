$(function(){
//==================================================================	
//MASCARAS PARA CAMPOS EM R$
//==================================================================
	$(".moeda").maskMoney({decimal: ",", thousands: "."});

//==================================================================	
//LIMITAR QUANTIDADE DE CARACTERES EM CAMPOS
//==================================================================
	$(".limite-2").on('keydown', function(e) {
		if ($(this).val().length >= 2 && e.keyCode != 8 && e.keyCode != 9) {
			return false;
		}
	});

//==================================================================	
//MUDA A COR DA LINHA DA TABELA NO CLICK
//==================================================================
	$('td').click(function(){
		//var row_index = $(this).parent().index();
		//var col_index = $(this).index();
		
		//$('#ID OU .CLASSE').toggleClass('CLASSE-PARA-PINTAR-LINHA');

		alert('Hello, World!');
	});

//==================================================================	
//INSERIR PRODUTO NA LISTA DE COMPRAS
//==================================================================	
	$('#btn-inserir').on("click",function(){
		alert('Hello, World!');
	});
});
