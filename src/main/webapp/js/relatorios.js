var id = null;

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
                    .append($("<td>").text(product.id_produto))
                    .append($("<td>").text(product.nome_produto))
                    .append($("<td>").text(product.qtd_itens))
                    .append($("<td>").text(product.categoria))
                    .append($("<td>").text(product.valor_uni))
                    .append($("<td>").text(product.valor_item));
        });
    });
});

$('#categoria').change(function() {
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

window.onload = function () {
    var table = document.getElementById('tableVendas');

    var count = table.getElementsByTagName('td').length;
    var formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
    });
    if (count > 0)
    {
        var total = 0;
        for (var i = 1; i < count; i++)
        {
            var f = parseFloat(table.rows[i].cells[4].innerHTML);
            total += f;
            document.getElementById("totalPesquisa").innerHTML = formatter.format(total);

        }
    }
};
