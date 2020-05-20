$(function () {

//==================================================================	
//VARIAVEIS GLOBAIS (isso n deveria ser feito assim faça melhor obg)
//==================================================================
    idItens = 0;
    idProduto = 0;
    produto = "";
    categoria = "";
    qtdEstoque = 0;
    valor = 0;
    valorTotal = 0;
    totalCompra = 0;
    qtdVendendo = 0;
    somaQtdVendendo = 0;

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
                        alert("Você não tem essa quantidade de produtos em estoque!");//caso nao tenha da uma mensagem
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
                    alert("Você não tem essa quantidade de produtos em estoque!");//envia uma mensagem de alerta
                }
            } else {//Se não selecionar nenhum produto
                alert("Você precisa selecionar um produto!");//envia uma mensagem de alerta
            }
        } else {//Se não definir a quantidade de produtos 
            alert("Você precisa escolher uma quantidade!");//envia uma mensagem de alerta
        }
    });

//==================================================================	
//REMOVER LINHA
//==================================================================	
    $(document).on('click', '#tb-itens-venda span', function (event) {//quando clicar na tabela itens-venda span
        //variáveis
        valorTotal = parseFloat($(this).closest('tr').find('td:eq(5)').text().replace("R$", ""));

        //Verificação
        if (confirm("Deseja mesmo exluir este item?") === true)
            $(this).closest('tr').remove();

        //Obtem valor atual da venda e remove valor do item selecionado
        totalCompra -= valorTotal;
        //Atualiza valor total da venda
        $('#total-compra').text("R$ " + totalCompra.toFixed(2));

        return false;
    });

//==================================================================	
//PAGAMENTO EM CREDITO VALIDACAO
//==================================================================
    $('#pag-cred').keyup(function () {//ao digitar no campo 
        if ($(this).val() > totalCompra) {//se o valor for maior que o total da compra
            alert("O valor do pagamento em crédito não pode ser maior que o total da compra!");//mostra um alert avisando
            $(this).val(0);//zera o campo pagamento em credito
        }

    });

//==================================================================	
//CALCULA O VALOR DO TROCO 
//==================================================================
    //variáveis
    pagDeb = 0;
    pagDin = 0;
    pagCred = 0;
    valDesc = 0;
    totPag = 0;
    totTroc = 0;

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
    $('#val-desc').keyup(function () {
        valDesc = parseFloat($('#val-desc').val().replace(",", ""));
        calcularTroco();
    });

    //funcao para calcular troco
    function calcularTroco() {
        totalCompra = parseFloat($('#total-compra').text().replace("R$", ""));

        //calcula o troco
        totPag = pagDeb + pagDin + pagCred + valDesc;
        totTroc = parseFloat(totPag) - totalCompra;

        //alert("Debito= "+pagDeb+"| Dinheiro= "+pagDin+"| Credito= "+pagCred+"| Desconto= "+valDesc+"| Tot Compra= "+totalCompra+"| Tot Pago= "+totPag+"| Troco= "+totTroc);

        //Coloca o troco no Input total troco
        $('#tot-troc').val(totTroc.toFixed(2));
    }
    
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
//PESQUISA CLIENTE 
//==================================================================
    $('#pesquisar-cliente').on('click', function(){
        //função em ajax para mandar o post para o servelet
        $.ajax({
            method: 'POST',//metodo post
            url: 'ConsultarClienteServlet',//servelet que recebe
            data: {
                cpf : $('#cpf-cliente').val(),
                acao : "pesquisacpf"
            }//dados a serem enviados
        }).always(function(responseJson) {
            console.log(responseJson);
            if(responseJson.responseText !== "Não encontrado!"){//se encontrar preenche com os dados
                $('#cli-id').val(responseJson.id);
                $('#cli-nome').text(responseJson.nome);
                $('#cli-cpf').text(responseJson.cpf);
            }else{//se não encontrar mostra modal
                $('#mensagem').text("Não existe cliente cadastrado com o CPF: "+$('#cpf-cliente').val()+".");//coloca o texto de retorno na modal
                $('#modalMensagem').modal('show');//mostra modal
            }
        });
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
