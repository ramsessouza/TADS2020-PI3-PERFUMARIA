$(function(){

//==================================================================	
//VARIAVEIS GLOBAIS (isso n deveria ser feito assim faça melhor obg)
//==================================================================
	idItens =0;	idProduto =0; produto ="";	categoria =""; qtdEstoque =0;
	valor =0; valorTotal =0; totalCompra =0; qtdVendendo=0; somaQtdVendendo =0;

//==================================================================	
//SELECIONAR ITEM NA TABELA DE PRODUTOS
//==================================================================
	$(document).on('click', '#tb-produtos tr', function(event){//quando clicar na tabela produtos linha
		//variáveis
		idProduto = parseInt($(this).find('td:eq(0)').text());//essa "tabela" procure a td de indice 0 e me da o texto
		produto = $(this).find('td:eq(1)').text();
		categoria = $(this).find('td:eq(2)').text();
		qtdEstoque = parseInt($(this).find('td:eq(3)').text());
		valor = parseFloat($(this).find('td:eq(4)').text().replace("R$","")).toFixed(2);
		valorTotal = qtdEstoque*valor;
		
		//remove a classe que colore em laranja de todas as linhas da tabela
		$('#tb-produtos tr').removeClass('linha-selecionada');
		//insere a classe que colore em laranja na linha selecionada
	    $(this).toggleClass("linha-selecionada");
	});

//==================================================================	
//INSERE UM PRODUTO NA LISTA DE COMPRAS
//==================================================================	
	$('#btn-inserir').on("click",function(){//quando clicar no botão inserir
		//variáveis
		var qtdInserindo = parseInt($('#qtd').val());
		totalCompra = parseFloat($('#total-compra').text().replace("R$",""));
		valorTotal = parseFloat(qtdInserindo * valor);

		//Verifica se foi definido uma quantidade de produtos para ser inserido na lista de itens
		if (qtdInserindo >= 1 || qtdInserindo <= qtdEstoque){
			//Verifica se selecionou algum item
			if(qtdEstoque !== 0){
				//Verifica se tem a quantidade solicitada em estoque
				if(qtdInserindo <= qtdEstoque){
					somaQtdVendendo = 0;
					//soma a quantidade de itens com o mesmo id do item inserido
					$('#tb-itens-venda tbody tr').each(function() {
						var idProdVenda = parseInt($(this).find('td:eq(1)').text());
			  			if(idProduto === idProdVenda ){
				  			qtdVendendo = parseInt($(this).find('td:eq(3)').text());
				  			somaQtdVendendo +=  qtdVendendo;
				  		}
				  	});
				  	//verifica se tem a quantidade em estoque em relacao 
				  	//a oque ja foi inserido e oque esta sendo inserido
				  	if(qtdEstoque < somaQtdVendendo + qtdInserindo){
						alert("Você ja inseriu na venda todos '"+produto+"' que você tinha em estoque!");//caso nao tenha da uma mensagem
			 			return;//e sai da funcao
			  		}
					//Novo id para um novo registro 
					idItens +=1;
					//Insere a linha nova na tabela de itens 
					$('#tb-itens-venda').find('tbody:last').append('<tr><td class="td-id">'+idItens+'</td><td class="td-id">'+idProduto+'</td><td class="td-produto">'+produto+'</td><td class="td-qtd">'+qtdInserindo+'</td><td class="td-valor">R$'+valor+'</td><td class="td-valor">R$'+valorTotal.toFixed(2)+'</td><td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td></tr>');
					//Atualiza o total da compra com o valor total do item inserido
					totalCompra += valorTotal;
					$('#total-compra').text("R$ " + totalCompra.toFixed(2));
				} else {//Se a qtd em estoque for abaixo do que o solicitado
					alert("Você não tem essa quantidade de produtos em estoque!");//envia uma mensagem de alerta
				}
			} else {//Se não selecionar nenhum produto
				alert("Você precisa selecionar um produto!");//envia uma mensagem de alerta
			}
		} else {//Se não definir a quantidade de produtos 
			alert("Você precisa colocar a quantidade a ser inserida na lista!");//envia uma mensagem de alerta
		}
	});

//==================================================================	
//REMOVER LINHA
//==================================================================	
	$(document).on('click', '#tb-itens-venda span', function(event){//quando clicar na tabela itens-venda span
		//variáveis
		valorTotal = parseFloat($(this).closest('tr').find('td:eq(5)').text().replace("R$",""));

		//Verificação
		if(confirm("Deseja mesmo exluir este item?")===true)
		$(this).closest('tr').remove(); 

		//Obtem valor atual da venda e remove valor do item selecionado
		totalCompra -= valorTotal;
		//Atualiza valor total da venda
       	$('#total-compra').text("R$ " + totalCompra.toFixed(2));
       	
       	return false;
	});

//==================================================================	
//MASCARAS
//==================================================================
	//valores decimais
	$(".moeda").maskMoney({decimal: ".", thousands: ","});

	//CPF
	$('.cpf').mask('999.999.999-99');

	//pagamento em crédito
	$('#pag-cred').keyup(function(){//ao digitar no campo 
		if($(this).val() > totalCompra){//se o valor for maior que o total da compra
			alert("O valor do pagamento em crédito não pode ser maior que o total da compra!");//mostra um alert avisando
			$(this).val(0);//zera o campo pagamento em credito
		}
		
	});

//==================================================================	
//LIMITADORES DE CARACTERES
//==================================================================
	//limita para 2
	$(".limite-2").on('keydown', function(e) {
		if ($(this).val().length >= 2 && e.keyCode !== 8 && e.keyCode !== 9) {
			return false;
		}
	});

//==================================================================	
//CALCULA O VALOR DO TROCO 
//==================================================================
	//variáveis
	pagDeb =0; pagDin =0; pagCred =0; valDesc =0; totPag =0; totTroc =0;

	//Quando digitar em qualquer campo chama a função de calcular o troco
	$('#pag-deb').keyup(function(){pagDeb = parseFloat($('#pag-deb').val()); calcularTroco();});
	$('#pag-din').keyup(function(){pagDin = parseFloat($('#pag-din').val()); calcularTroco();});
	$('#pag-cred').keyup(function(){pagCred = parseFloat($('#pag-cred').val()); calcularTroco();});
	$('#val-desc').keyup(function(){valDesc = parseFloat($('#val-desc').val()); calcularTroco();});

	//funcao para calcular troco
	function calcularTroco(){
		totalCompra = parseFloat($('#total-compra').text().replace("R$",""));

		//calcula o troco
		totPag = pagDeb + pagDin + pagCred + valDesc;
		totTroc = parseFloat(totPag) - totalCompra;
		
		//alert("Debito= "+pagDeb+"| Dinheiro= "+pagDin+"| Credito= "+pagCred+"| Desconto= "+valDesc+"| Tot Compra= "+totalCompra+"| Tot Pago= "+totPag+"| Troco= "+totTroc);
		
		//Coloca o troco no Input total troco
		$('#tot-troc').val(totTroc.toFixed(2));
	}
});
