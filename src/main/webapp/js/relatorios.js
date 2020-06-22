var id = null;
//==================================================================	
//AÇÕES: MOSTRA A MODAL COM OS DETALHES DA VENDA
//==================================================================
$('.linha').click(function () {
    $('.selected').removeClass('selected');
    $(this).addClass('selected');
    id = $(this).find('td:first').html();
    var categoria = $('#categoria').children("option:selected").val();
    $("#detalheTabela tbody").empty();
    $.get("DetalhesServlet", {id, categoria}, function (responseJson) {
        
        var $table = document.getElementById("detalheTabela");
        $.each(responseJson, function (index, product) {
            $("<tr>").appendTo($table)
                    //.append($("<td>").text(product.id_produto))
                    .append($("<td>").text(product.nome_produto))
                    .append($("<td>").text(product.categoria))
                    .append($("<td>").text(product.qtd_itens))
                    .append($("<td>").text(product.valor_uni))
                    .append($("<td>").text(product.valor_item));
        });
        $('#modalDetalhes').modal('show');
    });
});
//==================================================================	
//AÇÕES: FAZ FILTRO POR CATEGORIA DE PRODUTO NOS DETALHES
//==================================================================
$('#categoria').change(function () {
    var categoria = $('#categoria').children("option:selected").val();

    $("#detalheTabela tbody").empty();
    $.get("DetalhesServlet", {id, categoria}, function (responseJson) {
        var $table = document.getElementById("detalheTabela");
        $.each(responseJson, function (index, product) {
            $("<tr>").appendTo($table)
                    .append($("<td>").text(product.id_produto))
                    .append($("<td>").text(product.nome_produto))
                    .append($("<td>").text(product.qtd_itens))
                    .append($("<td>").text(product.categoria))
                    .append($("<td>").text(product.valor_uni))
                    .append($("<td>").text(product.valor_item));
        });
    });
});
//==================================================================	
//AÇÕES: FAZ CONTAGEM DO VALOR TOTAL DAS VENDAS
//==================================================================
window.onload = function () {
    var table = document.getElementById('tableVendas');
    var count = table.getElementsByTagName('td').length;
    var formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
    });
    $('#qtdVendas').text($('#tableVendas tr').length - 1);
    if (count > 0)
    {
        var total = 0;
        for (var i = 1; i < count; i++)
        {
            var f = parseFloat(table.rows[i].cells[5].innerHTML);
            total += f;
            document.getElementById("totalPesquisa").innerHTML = formatter.format(total);
        }
    }
};
//==================================================================	
//FUNÇÃO: OCULTA MODALS
//==================================================================    
    $('.fechar-modal').on("click",function(){
        $('#modalDetalhes').modal('hide');
        $('#modalErro').modal('hide');
    }); 


