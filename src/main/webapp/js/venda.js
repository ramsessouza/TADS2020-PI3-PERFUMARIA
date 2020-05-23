$(function () {

//==================================================================	
//VARIAVEIS GLOBAIS (isso n deveria ser feito assim faça melhor obg)
//==================================================================
    idItens = 0;//id dos itens inseridos na tabela vendas
    idProduto = 0;//id tb produto ao clicar na linha
    produto = "";//produto tb produto ao clicar na linha
    categoria = "";//categoria tb produto ao clicar na linha
    qtdEstoque = 0;//qtdEstoque tb produto ao clicar na linha
    valor = 0;//valor tb produto ao clicar na linha
    valorTotal = 0;//valorTotal tb produto ao clicar na linha
    totalCompra = 0;//total da compra (atualiza quando insere/remove itens)
    qtdVendendo = 0;//qtd de itens ja vendidos na tb itens venda de um produto
    somaQtdVendendo = 0;//soma dos itens ja vendidos na tb venda de um produto
    pagDeb = 0;//valor do pagamento em debito
    pagDin = 0;//valor do pagamento em dinheiro
    pagCred = 0;//valor do pagamento em credito
    valDesc = 0;//valor do desconto
    totPag = 0;//valor do total pago
    totTroc = 0;//valor do troco
//==================================================================	
//FUNÇÕES: MOSTRA MODAL
//==================================================================
    function mostraModalPadrao(mensagem){
        $('#registre-cliente').attr("hidden",true);//esconde registrar cliente agora da modal
        $('#h5-padrao').removeAttr('hidden');//mostra h5 padrao
        $('#h5-finalizar').attr("hidden",true);//esconde h5 finalizar
        $('#padrao-body').removeClass('esconder-div');//mostra podrao body da modal
        $('#finalizar-body').addClass('esconder-div');//esconde finalizar body da modal
        $('#padrao-footer').removeClass('esconder-div');//mostra padrao footer modal
        $('#finalizar-footer').addClass('esconder-div');//esconde finalizou footer modal
        $('#excluir-footer').addClass('esconder-div');//esconde footer excluir
        $('#mensagem').text(mensagem);//coloca o texto na modal
        $('#modalMensagem').modal('show');//mostra modal
    }
    function mostraModalExcluir(mensagem, idItem, valorItem){
        $('#registre-cliente').attr("hidden",true);//esconde registrar cliente agora da modal
        $('#h5-padrao').removeAttr('hidden');//mostra h5 padrao
        $('#h5-finalizar').attr("hidden",true);//esconde h5 finalizar
        $('#finalizar-body').addClass('esconder-div');//esconde finalizar body da modal
        $('#padrao-body').removeClass('esconder-div');//mostra podrao body da modal
        $('#excluir-footer').removeClass('esconder-div');//mostra excluir footer modal
        $('#finalizar-footer').addClass('esconder-div');//esconde finalizou footer modal
        $('#padrao-footer').addClass('esconder-div');//esconde footer padrao
        $('#idItenExcluir').val(idItem);//coloca o id do item pra ser excluido da tb itens venda
        $('#valorItenExluir').val(valorItem);//coloca o valor do item pra ser subtraido da venda
        $('#mensagem').text(mensagem);//coloca o texto na modal
        $('#modalMensagem').modal('show');//mostra modal
    }
    function mostraModalCadastraCliente(mensagem){
        $('#registre-cliente').removeAttr('hidden');//mostra o registrar cliente agora na modal
        $('#h5-padrao').removeAttr('hidden');//mostra h5 padrao
        $('#h5-finalizar').attr("hidden",true);//esconde h5 finalizar
        $('#padrao-body').removeClass('esconder-div');//esconde finalizou venda da modal
        $('#finalizar-body').addClass('esconder-div');//esconde finalizar body da modal
        $('#padrao-footer').removeClass('esconder-div');//mostra footer padrao da modal
        $('#finalizar-footer').addClass('esconder-div');//esconde finalizar footer da modal
        $('#excluir-footer').addClass('esconder-div');//esconde footer excluir da modal
        $('#mensagem').text(mensagem);//coloca o texto na modal
        $('#modalMensagem').modal('show');//mostra modal
    }
    function mostraModalFinalizar(){
        $('#registre-cliente').attr("hidden",true);//esconde registrar cliente agora da modal
        $('#h5-padrao').attr("hidden",true);//esconde h5 padrao
        $('#h5-finalizar').removeAttr('hidden');//mostra h5 finalizar
        $('#padrao-body').addClass('esconder-div');//esconde finalizou venda da modal
        $('#finalizar-body').removeClass('esconder-div');//mostra finalizar body da modal
        $('#finalizar-footer').removeClass('esconder-div');//mostra finalizar footer da modal
        $('#padrao-footer').addClass('esconder-div');//esconde footer padrao
        $('#excluir-footer').addClass('esconder-div');//esconde footer excluir
        
        //coloca valor nos campos da modal
        $('#venda-funcionario-nome').text($('#funcionario').text());
        $('#venda-cliente-id').text($('#cli-id').val());
        $('#venda-cliente-nome').text($('#cli-nome').text());
        $('#venda-cliente-cpf').text($('#cli-cpf').text());
        $('#venda-data').text($('#calendario').text());
        $('#venda-itens').text($('#tb-itens-venda tr').length-1);
        $('#venda-total').text($('#total-compra').text());
        $('#venda-dinheiro').text("R$ "+$('#pag-din').val());
        $('#venda-debito').text("R$ "+$('#pag-deb').val());
        $('#venda-credito').text("R$ "+$('#pag-cred').val());
        $('#venda-desconto').text("R$ "+$('#val-desc').val());
        $('#venda-troco').text("R$ "+$('#tot-troc').val());
        $('#venda-parcelas').text($('#tot-parc').find('option').filter(':selected').val());
        
        
        $('#modalMensagem').modal('show');//mostra modal
    }
//==================================================================	
//FUNÇÃO: OCULTA MODAL
//==================================================================    
    $('.fechar-modal').on("click",function(){
        $('#modalMensagem').modal('hide');//oculta modal
        //$('#formulario').trigger("reset");
    }); 
//==================================================================	
//PESQUISA PRODUTOS 
//==================================================================
    $('#pesquisa-produto').on('click', function(){
        //limpa a tabela
        $("#tb-produtos tbody").empty();
        //função em ajax para mandar o post para o servelet
        $.ajax({
            method: 'POST',//metodo post
            url: 'consultaProdutoServlet',//servelet que recebe
            data: {
                nomeProduto : $('#nome-produto').val()
            }//dados a serem enviados
        }).always(function(responseJson) {
            $.each(responseJson, function (index, produto) {
                $('#tb-produtos')
                .find('tbody:last')
                .append(
		'<tr><td class="td-id">' + produto.id + 
		'</td><td class="td-produto">' + produto.nome + 
		'</td><td>' + produto.categoria + 
		'</td><td>' + produto.quantidade + 
		'</td><td>R$ ' + produto.preco + 
		'</td></tr>');
            });
        });
    });
//==================================================================	
//SELECIONA ITEM NA TABELA DE PRODUTOS
//==================================================================
    $(document).on('click', '#tb-produtos tr', function (event) {//quando clicar na linha da tabela produtos 
        //variáveis
        idProduto = parseInt($(this).find('td:eq(0)').text());//essa "tabela" procure a td de indice 0 e me da o texto
        produto = $(this).find('td:eq(1)').text();
        categoria = $(this).find('td:eq(2)').text();
        qtdEstoque = parseInt($(this).find('td:eq(3)').text());
        valor = parseFloat($(this).find('td:eq(4)').text().replace("R$", "")).toFixed(2);
        valorTotal = qtdEstoque * valor;

        //remove a classe que colore em "dark" de todas as linhas da tabela
        $('#tb-produtos tr').removeClass('linha-selecionada');

        //insere a classe que colore em "dark" na linha selecionada
        $(this).toggleClass("linha-selecionada");
    });
//==================================================================	
//INSERE UM PRODUTO NA TABELA DE ITENS VENDA
//==================================================================	
    $('#btn-inserir').on("click", function () {//quando clicar no botão inserir
        //variáveis
        var qtdInserindo = parseInt($('#qtd').val());
        totalCompra = parseFloat($('#total-compra').text().replace("R$", ""));
        valorTotal = parseFloat(qtdInserindo * valor);

        //Verifica se foi definido uma quantidade de produtos para ser inserido na lista de itens
        if (qtdInserindo >= 1 || qtdInserindo <= qtdEstoque) {
            //Verifica se selecionou algum item
            if (qtdEstoque !== 0) {
                //Verifica se tem a quantidade solicitada em estoque
                if (qtdInserindo <= qtdEstoque) {
                    somaQtdVendendo = 0;
                    //soma a quantidade de itens com o mesmo id do item inserido
                    $('#tb-itens-venda tbody tr').each(function () {
                        var idProdVenda = parseInt($(this).find('td:eq(1)').text());
                        if (idProduto === idProdVenda) {
                            qtdVendendo = parseInt($(this).find('td:eq(3)').text());
                            somaQtdVendendo += qtdVendendo;
                        }
                    });
                    //verifica se tem a quantidade em estoque em relacao 
                    //a oque ja foi inserido e oque esta sendo inserido
                    if (qtdEstoque < somaQtdVendendo + qtdInserindo) {
                        mostraModalPadrao("Você não tem essa quantidade de produtos em estoque!");
                        return;//e sai da funcao
                    }
                    //Novo id para um novo registro 
                    idItens += 1;
                    //Insere a linha nova na tabela de itens 
                    $('#tb-itens-venda').find('tbody:last').append('<tr><td class="td-id">' + idItens + '</td><td class="td-id">' + idProduto + '</td><td class="td-produto">' + produto + '</td><td class="td-qtd">' + qtdInserindo + '</td><td class="td-valor">R$' + valor + '</td><td class="td-valor">R$' + valorTotal.toFixed(2) + '</td><td class="td-remover"><a href="#"><span class="fas fa-times"></span></a></td></tr>');
                    //Atualiza o total da compra com o valor total do itens inseridos
                    totalCompra += valorTotal;
                    $('#total-compra').text("R$ " + totalCompra.toFixed(2));
                } else {//Se a qtd em estoque for abaixo do que o solicitado
                    mostraModalPadrao("Você não tem essa quantidade de produtos em estoque!");
                }
            } else {//Se não selecionar nenhum produto
                mostraModalPadrao("Você precisa selecionar um produto!");
            }
        } else {//Se não definir a quantidade de produtos 
            mostraModalPadrao("Você precisa escolher uma quantidade!");
        }
    });
//==================================================================	
//REMOVE PRODUTO DA TABELA DE ITENS VENDA
//==================================================================	
    //quando clico no x 
    $(document).on('click', '#tb-itens-venda span', function (event) {//quando clicar na tabela itens-venda span
        linha = parseInt($(this).closest('tr').index());//pego index da linha e coloco na variavel
        id = $(this).closest('tr').find('td:eq(0)').text();//pega id e coloca na variavel
        valorItem = parseFloat($(this).closest('tr').find('td:eq(5)').text().replace("R$", ""));//pego valor e coloco na variavel
        mostraModalExcluir("Deseja mesmo excluir o item "+id+" ?", linha, valorItem);//mostro modal e coloco id e valor de forma oculta
    });
    
    //ao confirmar exclusao
    $('#excluir-item').on('click', function(){
        id = parseInt($('#idItenExcluir').val());
        valorTotal = $('#valorItenExluir').val();
        
        $('#tb-itens-venda tr').eq(id+1).closest('tr').remove();//remove a linha 
        
        //Obtem valor atual da venda e remove valor do item selecionado
        totalCompra -= valorTotal;
        //Atualiza valor total da venda
        $('#total-compra').text("R$ " + totalCompra.toFixed(2));
        $('#modalMensagem').modal('hide');//oculta modal
    });
    
//==================================================================	
//PESQUISA CLIENTE 
//==================================================================
    $('#pesquisar-cliente').on('click', function(){
        var cpfCliente = $('#cpf-cliente').val();
        
        if (cpfCliente !== ""){//se o campo estiver preenchido faz a pesquisa
            //função em ajax para mandar o post para o servelet
            $.ajax({
                method: 'POST',//metodo post
                url: 'ConsultarClienteServlet',//servelet que recebe
                data: {
                    cpf : cpfCliente,
                    acao : "pesquisacpf"
                }//dados a serem enviados
            }).always(function(responseJson) {
                console.log(responseJson);
                if(responseJson.responseText !== "Não encontrado!"){//se encontrar preenche com os dados
                    $('#cli-id').val(responseJson.id);
                    $('#cli-nome').text(responseJson.nome);
                    $('#cli-cpf').text(responseJson.cpf);
                }else{//se não encontrar mostra modal
                    mostraModalCadastraCliente("Não existe cliente cadastrado com o CPF: "+$('#cpf-cliente').val()+".");//coloca o texto de retorno na modal
                    $('#cpf-cliente').val("");//remove cpf pesquisado do input
                }
            });
        }else{//se o campo nao for preenchido
            mostraModalPadrao("Digite o CPF antes de pesquisar!");
        }
    });
//==================================================================	
//PAGAMENTO EM CREDITO VALIDACAO
//==================================================================
    $('#pag-cred').keyup(function () {//ao digitar no campo 
        pagCred = parseFloat($('#pag-cred').val().replace(",", ""));
        if (pagCred > totalCompra) {//se o valor for maior que o total da compra
            mostraModalPadrao("O valor do pagamento em crédito não pode ser maior que o total da compra!");//mostra um alert avisando
            $(this).val(0);//zera o campo pagamento em credito
        }
        if(pagCred >0){//se tiver valor pra credito
            $('.parcela select').val(1);//escolhe parcelamento
        }else{//se nao tiver valor para credito
            $('.parcela select').val("");//remove parcela
        }
    });

//==================================================================	
//CALCULA O VALOR DO TROCO 
//==================================================================
    //Quando digitar em qualquer campo chama a função de calcular o troco
    $('#pag-deb').keyup(function () {
        pagDeb = parseFloat($('#pag-deb').val().replace(",", ""));
        calcularTroco();
    });
    $('#pag-din').keyup(function () {
        pagDin = parseFloat($('#pag-din').val().replace(",", ""));
        calcularTroco();
    });
    $('#pag-cred').keyup(function () {
        pagCred = parseFloat($('#pag-cred').val().replace(",", ""));
        calcularTroco();
    });
    $('#tot-parc').bind("change keyup", function(event){
        if(pagCred <0.01){//se valor for menor que 0.01 
            $('.parcela select').val("");//remove parcela
        }
     });
        
    $('#val-desc').keyup(function () {
        valDesc = parseFloat($('#val-desc').val().replace(",", ""));
        if(valDesc <= totalCompra){//se valor de desconta for menor que total da compra
            calcularTroco();//calcula o troco
        }else{//se valor de desconto for maior que total dacompra
            mostraModalPadrao("Valor de desconto muito alto!");//mostra mensagem
            $(this).val("");//remove valor de desconto
        }
    });

    //funcao para calcular troco
    function calcularTroco() {
        totalCompra = parseFloat($('#total-compra').text().replace("R$", ""));
        zero=0;
        //calcula o troco
        totPag = pagDeb + pagDin + pagCred + valDesc;
        totTroc = parseFloat(totPag) - totalCompra;
        
        if(totTroc >= 0){
        //Coloca o troco no Input total troco
        $('#tot-troc').val(totTroc.toFixed(2));
        }else{
            $('#tot-troc').val(zero.toFixed(2));
        }
    }
//==================================================================	
//CANCELAR VENDA 
//==================================================================    
    $('#cancelar-venda').on("click",function() {
        location.reload();
    });
//==================================================================	
//VENDA PROXIMO
//==================================================================
    $('#venda-proximo').on("click",function(){
        totalCompra = parseFloat($('#total-compra').text().replace("R$", ""));
        valorFaltante = totalCompra-totPag;
        parcelas = $('#tot-parc').find('option').filter(':selected').val();
        
        if(totalCompra !== 0){//se a compra tiver valor
            if(totalCompra <= totPag){//se pagar tudo 
                if(pagCred > 0.01 && parcelas == ""){//se tiver valor credito e sem parcelas
                    mostraModalPadrao("Selecione a quantidade de parcelas!");//mostra mensagm
                }else{//se tiver valor credito e parcelas 
                    mostraModalFinalizar();//mostra proximo passo
                }
            }else{//se estover faltando grana
                mostraModalPadrao("Ainda Faltam: R$" +valorFaltante.toFixed(2)+".");//coloca o texto na modal
            }
        }else{//se a compra nao tiver valor
            mostraModalPadrao("Venda sem valor. Sua venda é inválida!");//coloca o texto na modal
        }
    });
//==================================================================	
//VENDA FINALIZAR (salva venda no banco)
//==================================================================
    $('#venda-finalizar').on("click",function(){
        ultimaVenda = 0;
        //função em ajax para mandar o post para o servelet
        $.ajax({
            method: 'POST',//metodo post
            url: 'CadastroVendaServlet',//servelet que recebe
            data: {//campos do formulario
                cliId : $('#venda-cliente-id').text(), 
                funcId : $('#venda-funcionario-id').val(), 
                qtdItens : $('#venda-itens').text(),//A data passo pelo servlet
                valTotal : $('#venda-total').text(),
                pagDin : $('#venda-dinheiro').text(),
                pagDeb : $('#venda-debito').text(),
                pagCred : $('#venda-credito').text(),
                parcelas : $('#venda-parcelas').text(),
                valDesc : $('#venda-desconto').text(),
                valTroc : $('#venda-troco').text()
            }
        }).always(function(response) {//retorno de salvar venda
            ultimaVenda = parseInt(response);//retorna o id da venda realizada no post
            linhasTabela = $('#tb-itens-venda tr').length - 1;//pega total de linhas da tabela
            i = 0;//usado no foreach
            
            //salva cada linha da tb itens venda
            $('#tb-itens-venda tbody tr').each(function () {
                vendaIdProd = parseInt($(this).find('td:eq(1)').text());//pega id do produto
                vendaQtdItem = parseInt($(this).find('td:eq(3)').text());//pega id do item
                valorTotal = parseFloat($(this).find('td:eq(5)').text().replace("R$", ""));//pega valor total
                
                //Manda um posta para cada linha para CadastroItensVendaServlet
                $.ajax({
                    method: 'POST',//metodo post
                    url: 'CadastroItensVendaServlet',//servelet que recebe
                    data: {//campos do formulario
                        idVenda : ultimaVenda,
                        idProduto : vendaIdProd,
                        qtdItens : vendaQtdItem,
                        valorTotal : valorTotal
                    }
                }).always(function(response) {//retorno de salvar item venda
                    mostraModalPadrao(response);//mostra modal com resposta
                    setTimeout(function()//em menos de 1 segundo
                    {
                     location.reload();//atualiza a pagina
                    }, 1000);
                });
            });
            console.log("Venda cadastrada!" + response);//retorno no log para verificação
        });
    });
});
