window.onload = function () {
            var table = document.getElementById('tableVendas');
            //alert("table" + table);
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
    
           // alert("cheguei");
    
//   // ===mask===
//    $(function(){
//	//para o rg
//	$('.mascara-data').mask('aa/aa/aaaa');
//        //para decimais
//	$(".mascara-decimais").maskMoney({decimal: ".", thousands: ","}).mask('9999999999');
//});