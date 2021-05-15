$(function(){
//==================================================================	
//ESTA FUNÇÃO ALTERA O LOGO DO CABEÇALHO
//==================================================================
	//Usa o id logocabecalho e a função de entrada do mouse
	$('#logocab').mouseenter(function(){
		//altera a imagem para imagem colorida
		$(this).attr("src","img/grupo-1.png");
	//Na saida
	}).mouseout(function(){
		//altera a imagem para imagem padrao
		$(this).attr("src","img/grupo-2.png");
	});
//==================================================================
//ESSA FUNÇÃO COLOCA A DATA NO CABEÇALHO COM O LOGO
//==================================================================
	//Cria elemento Date numa variavel
	now = new Date
	
	//Cria 2 vetores com os nomes de dias da semana e meses do ano
	dayName = new Array ("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado") 
	monName = new Array ("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro")
	
	//Cria variavel para mostrar uma mensagem, exemplo "Terça, 14 de Abril de 2020"
	var data = (dayName[now.getDay() ] + ", " + now.getDate () + " de " + monName[now.getMonth()]   +  " de "  +     now.getFullYear ());
	
	//Criando objeto span
	var span = document.createElement("span");	
	//Colocando a classe icone no span
	span.className = "fas fa-calendar-alt";
	
	//Pegando o elemento h1 colocando a data
	$('#calendario').text(" " + data);

	//Colocando o span dentro do H1 ja com o icone
	$('#calendario').prepend(span);

//==================================================================
//FUNCAO DA BARRA LATERAL RECOLHER E EXPANDIR
//==================================================================	
	//Ao clicar no botao hamburger
	$('#hamburger').on('click', function() {
                //A classe .ativo do css vai para a #barra-lateral e #conteudo-pagina, ao clicar novamente é retirado
		$('#barra-lateral, #conteudo-pagina').toggleClass('ativo');
	});

//==================================================================
//FUNCAO QUANDO APERTA OS BOTÕES DA BARRA LATERAL
//==================================================================	
	//Ao segurar o click - encapsula o .item-linha que foi pressionado
	$('.item-linha').mousedown(function(){
		//troca o css dele para as configurações abaixo
		$(this).css({'color' : 'black' , 'background-color': 'rgb(244 128 41)'});
		//encontre o <span>/icone dele e troca o css dele para as configurações abaixo
		$(this).find('span').css("color", "black");
	}).mouseup(function(){
		//troca o css dele para as configurações abaixo
		$(this).css({'color' : 'white' , 'background-color': ''});
		//encontre o <span>/icone dele e troca o css dele para as configurações abaixo
		$(this).find('span').css("color", "rgb(244 128 41)");
	});
});